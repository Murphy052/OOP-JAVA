/**
 * This class represents weather information obtained from the OpenWeatherMap API.
 * It contains attributes such as weather ID, main weather condition, description, and icon.
 */
package Weather.weather;

public class Weather {
    private int id; // Weather condition ID
    private String main; // Main weather condition
    private String description; // Description of weather condition
    private String icon; // Weather icon ID

    // Getter and setter for 'id'
    /**
     * Retrieves the weather condition ID.
     *
     * @return Weather condition ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the weather condition ID.
     *
     * @param id The weather condition ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for 'main'
    /**
     * Retrieves the main weather condition.
     *
     * @return Main weather condition.
     */
    public String getMain() {
        return main;
    }

    /**
     * Sets the main weather condition.
     *
     * @param main The main weather condition to set.
     */
    public void setMain(String main) {
        this.main = main;
    }

    // Getter and setter for 'description'
    /**
     * Retrieves the description of the weather condition.
     *
     * @return Description of the weather condition.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the weather condition.
     *
     * @param description The description of the weather condition to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for 'icon'
    /**
     * Retrieves the ID of the weather icon.
     *
     * @return Weather icon ID.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the ID of the weather icon.
     *
     * @param icon The weather icon ID to set.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
