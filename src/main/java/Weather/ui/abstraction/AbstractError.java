package Weather.ui.abstraction;

import javax.swing.*;

/**
 * This abstract class serves as a base class for defining error dialogs in the Weather application UI.
 * It extends `javax.swing.JFrame` and provides common functionalities for error windows.
 */
public abstract class AbstractError extends JFrame {

    /**
     * Default constructor for the `AbstractError` class.
     * Creates a new error dialog with a specified title, default size (400x300 pixels), and centers it on the screen.
     *
     * @param title The title to be displayed on the error dialog window.
     */
    public AbstractError(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Set default size
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    /**
     * Constructor for the `AbstractError` class allowing customization of the window size.
     * Creates a new error dialog with a specified title, width, height, and centers it on the screen.
     *
     * @param title The title to be displayed on the error dialog window.
     * @param width The desired width of the error dialog window in pixels.
     * @param height The desired height of the error dialog window in pixels.
     */
    public AbstractError(String title, int width, int height) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height); // Set custom size
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    /**
     * Abstract method that must be implemented by subclasses to define the specific components (labels, buttons, etc.)
     * to be displayed within the error dialog.
     */
    public abstract void initComponents();

    /**
     * This method initializes the components defined in the `initComponents` method and makes the error dialog visible.
     */
    public void showFrame() {
        this.initComponents();
        this.setVisible(true);
    }
}
