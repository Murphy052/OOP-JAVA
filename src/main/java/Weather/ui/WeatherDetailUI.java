package Weather.ui;

import Weather.core.base.weather.WeatherDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherDetailUI extends JFrame{

    public WeatherDetailUI(WeatherDetail wd) {

        setTitle(STR."Weather App - \{wd.getTimezone()}");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set background image based on weather description
        String backgroundImage = getBackgroundImage(wd.getCurrent().getWeather().getFirst().getDescription());
        setContentPane(new JLabel(new ImageIcon(backgroundImage)));

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setOpaque(false); // Make panel transparent

        // Set foreground color for text labels
        Color textColor = new Color(255, 255, 255, 200); // White color with transparency
        Font textFont = new Font("Arial", Font.BOLD, 14);

        JLabel temperatureLabel = new JLabel(STR."Temperature: \{String.format("%.2f", wd.getCurrent().getTemp())}°C");
        temperatureLabel.setForeground(textColor);
        temperatureLabel.setFont(textFont);

        JLabel humidityLabel = new JLabel(STR."Humidity: \{wd.getCurrent().getHumidity()}%");
        humidityLabel.setForeground(textColor);
        humidityLabel.setFont(textFont);

        JLabel descriptionLabel = new JLabel(STR."Description: \{wd.getCurrent().getWeather().getFirst().getDescription()}");
        descriptionLabel.setForeground(textColor);
        descriptionLabel.setFont(textFont);

        JButton backButton = new JButton("Back to Enter City");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the second page
                new CityInput(); // Open the first page
            }
        });
        backButton.setForeground(textColor);
        backButton.setFont(textFont);

        panel.add(temperatureLabel);
        panel.add(humidityLabel);
        panel.add(descriptionLabel);
        panel.add(backButton);

        // Add panel to content pane
        getContentPane().add(panel);

        setVisible(true);
    }

    private String getBackgroundImage(String description) {
        // Determine background image based on weather description
        if (description.contains("rain") || description.contains("drizzle")) {
            return "C:\\Users\\Zrac\\Downloads\\rainy.jpg";
        } else if (description.contains("cloud")) {
            return "C:\\Users\\Zrac\\Downloads\\cloudy.jpg";
        } else if (description.contains("snow")) {
            return "C:\\Users\\Zrac\\Downloads\\snowy.jpg";
        } else if (description.contains("clear") || description.contains("sun")) {
            return "src/main/java/Weather/static/sunny.jpg";
        } else {
            return "C:\\Users\\Zrac\\Downloads\\default.jpg"; // Default background image
        }
    }


}