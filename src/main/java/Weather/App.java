package Weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import Weather.core.base.weather.WeatherDetail;
import Weather.core.settings.WeatherApiKey;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherApiKey apiKey = new WeatherApiKey();
        apiKey.setToken();

        WeatherDetail detail = WeatherDetail.get_weather_detail(apiKey.getToken());
        System.out.println(detail.getCurrent().getTemp());
    }
}