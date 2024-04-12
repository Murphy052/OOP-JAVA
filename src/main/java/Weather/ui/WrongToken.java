package ui;

import ui.base.AbstractError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WrongToken extends AbstractError {

    public WrongToken(String title) {
        super(title);
    }

    public WrongToken(String title, int width, int height) {
        super(title, width, height);
    }

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

        // Submit button
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

        // Action listener for submit button
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
