package Weather.core.settings;

import Weather.core.base.Token;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Weather.ui.WrongToken;


public class WeatherApiKey extends Token {
    public WeatherApiKey() {
        this.setToken();
    }

    private void setTokenFromEnv() throws Exception{
        Path path = Paths.get(".token");
        this.token = Files.readString(path);

        if (this.token == null) throw new Exception("Invalid token");
    }

    public void setToken() {
        try {
            this.setTokenFromEnv();
        } catch (Exception e) {
            e.printStackTrace();
            new WrongToken("Wrong Token").showFrame();
        }
    }
}
