package Weather.core;

import Weather.core.abstraction.Token;
import Weather.ui.WrongToken;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The WeatherApiKey class represents an API key used for accessing weather data.
 * It extends the Token abstract class and implements the necessary methods to set the API key.
 */
public class WeatherApiKey extends Token {

    /**
     * Constructs a new WeatherApiKey instance and sets the API key.
     */
    public WeatherApiKey() {
        this.setToken();
    }

    /**
     * Sets the API key by reading it from the environment file.
     *
     * @throws Exception if the API key is not found or is invalid
     */
    private void setTokenFromEnv() throws Exception {
        Path path = Paths.get(".token");
        this.token = Files.readString(path);

        if (this.token == null) throw new Exception("Invalid token");
    }

    /**
     * Sets the API key by calling the setTokenFromEnv method and handles any exceptions.
     */
    public void setToken() {
        try {
            this.setTokenFromEnv();
        } catch (Exception e) {
            e.printStackTrace();
            new WrongToken("Wrong Token").showFrame();
        }
    }
}
