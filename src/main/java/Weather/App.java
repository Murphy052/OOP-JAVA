package Weather;

import Weather.core.base.weather.WeatherDetail;
import Weather.core.settings.WeatherApiKey;
import Weather.ui.WeatherDetailUI;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherApiKey apiKey = new WeatherApiKey();

        WeatherDetail detail = WeatherDetail.get_weather_detail(apiKey.getToken());

        new WeatherDetailUI(detail);
    }
}