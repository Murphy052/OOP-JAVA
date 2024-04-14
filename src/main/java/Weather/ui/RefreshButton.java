package Weather.ui;

import javax.swing.*;
import java.awt.*;


public class RefreshButton {
    public static JButton createButton() {
        Image img = new ImageIcon("src/main/java/Weather/static/refresh.png").getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        JButton refreshButton = new JButton(new ImageIcon(img));

        refreshButton.setPreferredSize(new Dimension(30, 30));
        refreshButton.setContentAreaFilled(false);
        refreshButton.setBorderPainted(false);
        refreshButton.setFocusPainted(false);

        return refreshButton;
    }
}
