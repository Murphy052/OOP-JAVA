package Weather.ui;

import java.awt.*;

public class Colors {
    private Color textColor;
    private Color primaryColor;
    private Color secondaryColor;

    public Colors(boolean isDayTime, String description) {
        Color color1;
        Color color2;
        Color textColor = isDayTime ? Color.BLACK : Color.WHITE;

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

    public Colors(Color primaryColor, Color secondaryColor, Color textColor) {
        setTextColor(textColor);
        setPrimaryColor(primaryColor);
        setSecondaryColor(secondaryColor);
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getTextColor() {
        return textColor;
    }
}
