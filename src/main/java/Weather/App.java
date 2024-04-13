package Weather;

import Weather.ui.WeatherDetailUI;
import Weather.core.base.weather.WeatherDetail;
import Weather.core.settings.WeatherApiKey;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherApiKey apiKey = new WeatherApiKey();
        apiKey.setToken();

        WeatherDetail detail = WeatherDetail.get_weather_detail(apiKey.getToken());

        new WeatherDetailUI(detail);
    }
}