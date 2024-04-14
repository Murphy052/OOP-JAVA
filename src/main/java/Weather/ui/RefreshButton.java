package Weather.ui;

import javax.swing.*;
import java.awt.*;


/**
 * This class provides a utility method to create a JButton representing a refresh button.
 * The button is configured with a custom image, preferred size, and disabled visual elements for a clean appearance.
 */
public class RefreshButton {

    /**
     * Creates a JButton representing a refresh button with a custom image.
     *
     * @return A JButton configured as a refresh button.
     */
    public static JButton createButton() {
        // Load image, create button with icon, and customize appearance
        Image img = new ImageIcon("src/main/java/Weather/static/refresh.png").getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        JButton refreshButton = new JButton(new ImageIcon(img));

        refreshButton.setPreferredSize(new Dimension(30, 30));
        refreshButton.setContentAreaFilled(false);
        refreshButton.setBorderPainted(false);
        refreshButton.setFocusPainted(false);

        return refreshButton;
    }
}

