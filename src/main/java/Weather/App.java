package Weather;

import Weather.weather.WeatherDetail;
import Weather.core.WeatherApiKey;
import Weather.ui.AppUI;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherApiKey apiKey = new WeatherApiKey();

        WeatherDetail detail = WeatherDetail.get_weather_detail(apiKey.getToken());

        new AppUI(detail, apiKey.getToken());
    }
}