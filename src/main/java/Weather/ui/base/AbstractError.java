package Weather.ui.base;

import javax.swing.*;

public abstract class AbstractError extends JFrame{
    public AbstractError(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Set default size
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public AbstractError(String title, int width, int height) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height); // Set default size
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public abstract void initComponents();

    public void showFrame() {
        this.initComponents();
        this.setVisible(true);
    }
}