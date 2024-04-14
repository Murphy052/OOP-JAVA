package Weather.ui.base;

import java.awt.*;

public class Colors {
    private Color textColor;
    private Color primaryColor;
    private Color secondaryColor;

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
