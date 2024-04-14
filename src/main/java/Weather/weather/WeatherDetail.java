/**
 * This class represents detailed weather information retrieved from the OpenWeatherMap API.
 * It includes methods to fetch weather data based on coordinates or city name.
 */
package Weather.weather;

import Weather.location.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherDetail {
    private double lat; // Latitude
    private double lon; // Longitude
    private String timezone; // Timezone name
    private int timezone_offset; // Timezone offset in seconds
    private CurrentWeather current; // Current weather data
    private List<Daily> daily; // Weather forecast for the next seven days
    private String coord; // Coordinates as a string

    final private static String APIUrl = "https://api.openweathermap.org/data/";

    /**
     * Retrieves weather details based on geographical coordinates.
     *
     * @param token The API token for accessing OpenWeatherMap data.
     * @return WeatherDetail object containing weather information.
     * @throws JsonProcessingException If there's an issue processing JSON data.
     */
    public static WeatherDetail get_weather_detail(String token) throws JsonProcessingException {
        Location location = new Location();

        String requestUrl = APIUrl + "3.0/onecall?lat=" + location.getLatitude() + "&lon=" + location.getLongitude() + "&exclude=hourly,minutely&appid=" + token;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherDetail object = objectMapper.readValue(response.body(), WeatherDetail.class);

        return object;
    }

    /**
     * Retrieves weather details based on city name.
     *
     * @param token The API token for accessing OpenWeatherMap data.
     * @param city  The name of the city for which weather information is needed.
     * @return WeatherDetail object containing weather information.
     * @throws JsonProcessingException If there's an issue processing JSON data.
     */
    public static WeatherDetail get_weather_detail_by_city(String token, String city) throws JsonProcessingException {
        String requestUrl = APIUrl + "2.5/weather?q=" + city + "&exclude=hourly,minutely&appid=" + token;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherDetail object = objectMapper.readValue(response.body(), WeatherDetail.class);

        return object;
    }

    // Getter and setter for 'lat'
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    // Getter and setter for 'lon'
    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    // Getter and setter for 'timezone'
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    // Getter and setter for 'timezone_offset'
    public int getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(int timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    // Getter and setter for 'current'
    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    // Getter and setter for 'daily'
    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }


    /**
     * Retrieves the temperature in Celsius.
     *
     * @return Temperature in Celsius.
     */
    public String getTemperatureF() {
        return String.format("%.2f", this.getCurrent().getTemp()) + "°C";
    }


    /**
     * Retrieves the weather description.
     *
     * @return Weather description.
     */
    public String getDescription() {
        return this.getCurrent().getWeather().getFirst().getDescription();
    }

    /**
     * Retrieves the formatted weather description.
     *
     * @return Formatted weather description.
     */
    public String getDescriptionF() {
        String input = this.getDescription();
        return Arrays.stream(input.split("\\s+"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }

    /**
     * Retrieves extra weather details in a formatted manner.
     *
     * @return List of extra weather details.
     */
    public List<String> getExtraDetailsF() {
        List<String> ed = new ArrayList<String>();
        ed.add("Feels Like  " + String.format("%.2f", this.getCurrent().getFeels_like()) + "°C");
        ed.add("Wind  " + this.getCurrent().getWind_speed());
        ed.add("Visibility  " + this.getCurrent().getVisibility());
        ed.add("Pressure  " + this.getCurrent().getPressure());
        ed.add("Humidity  " + this.getCurrent().getHumidity() + "%");
        ed.add("Dew Point  " + String.format("%.2f", this.getCurrent().getDew_point()) + "°C");

        return ed;
    }

    /**
     * Checks if it's currently daytime at the location.
     *
     * @return True if it's daytime, false otherwise.
     */
    public boolean isDaytime() {
        long unixTimeSeconds = this.getCurrent().getDt(); // Unix time in seconds
        long unixTimeMillis = unixTimeSeconds * 1000L; // Convert seconds to milliseconds

        // Convert Unix time in milliseconds to Instant
        Instant instant = Instant.ofEpochMilli(unixTimeMillis);

        // Convert Instant to ZonedDateTime specifying UTC timezone
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));

        // Extract LocalTime from ZonedDateTime
        LocalTime localTime = zonedDateTime.toLocalTime();

        return localTime.isAfter(LocalTime.of(6, 0)) && localTime.isBefore(LocalTime.of(18, 0));
    }
}
