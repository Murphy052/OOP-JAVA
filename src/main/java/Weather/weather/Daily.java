/**
 * This class represents daily weather information obtained from the OpenWeatherMap API.
 * It includes attributes such as date, sunrise time, sunset time, moonrise time, moonset time,
 * moon phase, summary, temperature, feels-like temperature, pressure, humidity, dew point,
 * wind speed, wind direction, wind gust, weather conditions, cloudiness, probability of precipitation,
 * amount of rain, and UV index.
 */
package Weather.weather;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Daily {
    private long dt; // Date and time
    private long sunrise; // Sunrise time
    private long sunset; // Sunset time
    private long moonrise; // Moonrise time
    private long moonset; // Moonset time
    private double moon_phase; // Moon phase
    private String summary; // Summary of the daily weather
    private Temperature temp; // Temperature information
    private Temperature feels_like; // Feels-like temperature
    private int pressure; // Atmospheric pressure
    private int humidity; // Humidity percentage
    private double dew_point; // Dew point temperature
    private double wind_speed; // Wind speed
    private int wind_deg; // Wind direction in degrees
    private double wind_gust; // Wind gust speed
    private Weather[] weather; // Weather conditions
    private int clouds; // Cloudiness percentage
    private double pop; // Probability of precipitation
    private double rain; // Amount of rain
    private double uvi; // UV index

    // Setters and getters

    /**
     * Retrieves the date and time of the daily weather forecast.
     *
     * @return Date and time in Unix timestamp format.
     */
    public long getDt() {
        return dt;
    }

    /**
     * Sets the date and time of the daily weather forecast.
     *
     * @param dt Date and time in Unix timestamp format.
     */
    public void setDt(long dt) {
        this.dt = dt;
    }

    /**
     * Retrieves the sunrise time.
     *
     * @return Sunrise time in Unix timestamp format.
     */
    public long getSunrise() {
        return sunrise;
    }

    /**
     * Sets the sunrise time.
     *
     * @param sunrise Sunrise time in Unix timestamp format.
     */
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * Retrieves the sunset time.
     *
     * @return Sunset time in Unix timestamp format.
     */
    public long getSunset() {
        return sunset;
    }

    /**
     * Sets the sunset time.
     *
     * @param sunset Sunset time in Unix timestamp format.
     */
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public long getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(long moonrise) {
        this.moonrise = moonrise;
    }

    public long getMoonset() {
        return moonset;
    }

    public void setMoonset(long moonset) {
        this.moonset = moonset;
    }

    public double getMoon_phase() {
        return moon_phase;
    }

    public void setMoon_phase(double moon_phase) {
        this.moon_phase = moon_phase;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public Temperature getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Temperature feels_like) {
        this.feels_like = feels_like;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getDew_point() {
        return dew_point;
    }

    public void setDew_point(double dew_point) {
        this.dew_point = dew_point;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg;
    }

    public double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    // Nested class for Temperature
    public static class Temperature {
        private double day;
        private double min;
        private double max;
        private double night;
        private double eve;
        private double morn;

        // Setters and getters

        public double getDay() {
            return day;
        }

        public void setDay(double day) {
            this.day = day - 273.15;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min - 273.15;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max - 273.15;
        }

        public double getNight() {
            return night;
        }

        public void setNight(double night) {
            this.night = night - 273.15;
        }

        public double getEve() {
            return eve;
        }

        public void setEve(double eve) {
            this.eve = eve - 273.15;
        }

        public double getMorn() {
            return morn;
        }

        public void setMorn(double morn) {
            this.morn = morn - 273.15;
        }
    }
    /**
     * Retrieves the maximum temperature of the day in Fahrenheit.
     *
     * @return Maximum temperature in Fahrenheit.
     */
    public String getTemperatureF() {
        return String.format("%.0f", this.getTemp().getMax()) + "°";
    }

    /**
     * Retrieves the formatted description of the weather conditions.
     *
     * @return Formatted description of weather conditions.
     */
    public String getDescriptionF() {
        String input = this.getWeather()[0].getDescription();
        return Arrays.stream(input.split("\\s+"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }

    /**
     * Retrieves the formatted time of the daily forecast.
     *
     * @return Formatted time of the daily forecast.
     */
    public String getTimeF() {
        long unixTimeSeconds = this.getDt();
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(unixTimeSeconds, 0, ZoneOffset.UTC);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E d");

        return dateTime.format(formatter);
    }
}
