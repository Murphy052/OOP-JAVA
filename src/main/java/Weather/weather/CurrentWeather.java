package Weather.weather;

import java.util.List;

/**
 * This class represents the current weather conditions obtained from the OpenWeatherMap API.
 * It includes attributes such as date and time, sunrise time, sunset time, temperature, feels-like temperature,
 * pressure, humidity, dew point, UV index, cloudiness, visibility, wind speed, wind direction, wind gust,
 * and weather conditions.
 */
public class CurrentWeather {
    private long dt; // Date and time
    private long sunrise; // Sunrise time
    private long sunset; // Sunset time
    private double temp; // Temperature in Celsius
    private double feels_like; // Feels-like temperature in Celsius
    private int pressure; // Atmospheric pressure
    private int humidity; // Humidity percentage
    private double dew_point; // Dew point temperature in Celsius
    private double uvi; // UV index
    private int clouds; // Cloudiness percentage
    private int visibility; // Visibility in meters
    private double wind_speed; // Wind speed in meters per second
    private int wind_deg; // Wind direction in degrees
    private double wind_gust; // Wind gust speed in meters per second
    private List<Weather> weather; // Weather conditions

    // Getter and setter for 'dt'
    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    // Getter and setter for 'sunrise'
    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    // Getter and setter for 'sunset'
    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    // Getter and setter for 'temp'
    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp - 273.15;
    }

    // Getter and setter for 'feels_like'
    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like - 273.15;
    }

    // Getter and setter for 'pressure'
    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    // Getter and setter for 'humidity'
    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    // Getter and setter for 'dew_point'
    public double getDew_point() {
        return dew_point;
    }

    public void setDew_point(double dew_point) {
        this.dew_point = dew_point - 273.15;
    }

    // Getter and setter for 'uvi'
    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    // Getter and setter for 'clouds'
    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    // Getter and setter for 'visibility'
    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    // Getter and setter for 'wind_speed'
    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    // Getter and setter for 'wind_deg'
    public int getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg;
    }

    // Getter and setter for 'wind_gust'
    public double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }

    // Getter and setter for 'weather'
    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}

