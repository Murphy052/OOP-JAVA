package Weather.ui;

import java.awt.*;

/**
 * This class represents a color scheme for the weather application.
 * It provides two ways to create a `Colors` object:
 *  1. Based on the current weather conditions (daytime/nighttime and description).
 *  2. By specifying specific colors for the primary, secondary, and text colors.
 */
public class Colors {

    /**
     * The text color used for labels and text elements in the UI.
     */
    private Color textColor;

    /**
     * The primary color used as the main background or accent color.
     */
    private Color primaryColor;

    /**
     * The secondary color used for accents or contrasting elements.
     */
    private Color secondaryColor;

    /**
     * Creates a `Colors` object based on the current weather conditions (daytime/nighttime and description).
     * This constructor determines the primary and secondary colors based on the provided weather description
     * and whether it's daytime or nighttime.
     *
     * @param isDayTime True if it's daytime, False if nighttime.
     * @param description The weather description (e.g., "clear", "rainy", "cloudy").
     */
    public Colors(boolean isDayTime, String description) {
        Color color1;
        Color color2;
        textColor = isDayTime ? Color.BLACK : Color.WHITE; // Set text color based on daytime

        // Set primary and secondary colors based on description and daytime
        if (description.contains("rain") || description.contains("drizzle")) {
            color1 = isDayTime ? Color.BLUE : new Color(70, 130, 180); // Blue or steel blue
            color2 = isDayTime ? new Color(135, 206, 250) : new Color(112, 128, 144); // Light Sky Blue or slate gray
        } else if (description.contains("cloud")) {
            color1 = isDayTime ? new Color(169, 169, 169) : new Color(105, 105, 105); // Dark Gray or dim gray
            color2 = isDayTime ? new Color(192, 192, 192) : new Color(112, 128, 144); // Light Gray or slate gray
        } else if (description.contains("snow")) {
            color1 = isDayTime ? Color.WHITE : new Color(240, 255, 240); // White or honeydew
            color2 = isDayTime ? new Color(240, 255, 240) : new Color(255, 250, 250); // Honeydew or snow
        } else if (description.contains("clear") || description.contains("sun")) {
            color1 = isDayTime ? new Color(135, 206, 250) : new Color(11, 0, 33); // Yellow or dark gray
            color2 = isDayTime ? Color.YELLOW : new Color(0, 33, 66); // Gold or slate gray
        } else {
            color1 = isDayTime ? Color.WHITE : new Color(192, 192, 192); // White or light gray
            color2 = isDayTime ? new Color(192, 192, 192) : new Color(112, 128, 144); // Light Gray or slate gray
        }

        setTextColor(textColor);
        setPrimaryColor(color1);
        setSecondaryColor(color2);
    }

    /**
     * Creates a `Colors` object with specific colors for primary, secondary, and text.
     * This constructor allows you to provide pre-defined colors for the color scheme.
     *
     * @param primaryColor The primary color for the scheme.
     * @param secondaryColor The secondary color for the scheme.
     * @param textColor The text color for the UI elements.
     */
    public Colors(Color primaryColor, Color secondaryColor, Color textColor) {
        setTextColor(textColor);
        setPrimaryColor(primaryColor);
        setSecondaryColor(secondaryColor);
    }

    /**
    * Sets the primary color for the scheme.
    *
     * @param primaryColor The new primary color.
    */
    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    /**
     * Gets the current primary color.
     *
     * @return The primary color.
     */
    public Color getPrimaryColor() {
        return primaryColor;
    }

    /**
     * Sets the secondary color for the scheme.
     *
     * @param secondaryColor The new secondary color.
     */
    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    /**
     * Gets the current secondary color.
     *
     * @return The secondary color.
     */
    public Color getSecondaryColor() {
        return secondaryColor;
    }

    /**
     * Sets the text color used for labels and text elements in the UI.
     *
     * @param textColor The new text color.
     */
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    /**
     * Gets the current text color.
     *
     * @return The text color.
     */
    public Color getTextColor() {
        return textColor;
    }
}
