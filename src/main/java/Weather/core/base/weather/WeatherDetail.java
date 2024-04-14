package Weather.core.base.weather;

import Weather.location.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class WeatherDetail {
    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private CurrentWeather current;

    final private static String APIUrl = "https://api.openweathermap.org/data/3.0/onecall";

    public static WeatherDetail get_weather_detail(String token) throws JsonProcessingException {
        Location location = new Location();

        String requestUrl = APIUrl + "?lat=" + location.getLatitude() + "&lon=" + location.getLongitude() + "&exclude=hourly,daily,minutely&appid=" + token;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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

    public String getTemperatureF() {
        return String.format("%.2f", this.getCurrent().getTemp()) + "°C";
    }

    public String getDescription() {
        return this.getCurrent().getWeather().getFirst().getDescription();
    }

    public String getDescriptionF() {
        return this.getCurrent().getWeather().getFirst().getDescription();
    }

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
}
