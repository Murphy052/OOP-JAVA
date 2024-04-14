package Weather.ui;

import Weather.ui.abstraction.AbstractError;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a specific error dialog displayed when the user's OpenWeatherMap API token is not found or invalid.
 * It inherits from the `Weather.ui.abstraction.AbstractError` class and provides a customized error message and input field for the user to enter a new token.
 */
public class WrongToken extends AbstractError {

    /**
     * Default constructor for the `WrongToken` class.
     * Creates a new error dialog with a default title "Wrong Token" and default size (400x150 pixels), centered on the screen.
     */
    public WrongToken(String title) {
        super(title);
    }

    /**
     * Constructor for the `WrongToken` class allowing customization of the window size.
     * Creates a new error dialog with a specified title, width, and height, centered on the screen.
     *
     * @param title The title to be displayed on the error dialog window.
     * @param width The desired width of the error dialog window in pixels.
     * @param height The desired height of the error dialog window in pixels.
     */
    public WrongToken(String title, int width, int height) {
        super(title, width, height);
    }

    /**
     * Overrides the `initComponents` method from the abstract class to define the specific components for this error dialog.
     * Creates a main panel with an error message label (including a hyperlink to openweathermap.org), an input field for a new token, and a submit button (functionality not implemented yet).
     */
    @Override
    public void initComponents() {
        // Set up main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Error message label
        JLabel errorMessageLabel = new JLabel("<html><font color='red'>Token not found or is invalid. Please visit <a href='https://openweathermap.org'>openweathermap.org</a> to get a new token</font></html>");
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(errorMessageLabel, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField inputField = new JTextField(20);
        inputPanel.add(inputField);

        // Submit button (functionality not implemented)
        JButton submitButton = new JButton("Submit");
        inputPanel.add(submitButton);

        // Add input panel to main panel
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Set up frame
        getContentPane().add(mainPanel);

        // Set up frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Link styling for HTML
        errorMessageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        errorMessageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://openweathermap.org"));
                } catch (java.net.URISyntaxException | java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Action listener for submit button (not implemented yet)
//        submitButton.addActionListener(e -> {
//            String input = inputField.getText();
//            if (validateInput(input)) {
//                clearErrorMessage();
//                handleInput(input);
//            } else {
//                setErrorMessage("Invalid input!");
//            }
//        });
    }
}
