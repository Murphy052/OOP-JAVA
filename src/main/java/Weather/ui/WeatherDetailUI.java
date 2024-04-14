package Weather.ui;

import Weather.core.base.weather.WeatherDetail;
import Weather.ui.base.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.time.LocalTime;
import java.util.ListIterator;

public class WeatherDetailUI extends JFrame {

    private WeatherDetail wd;
    private Colors colors;

    public WeatherDetailUI(WeatherDetail wd) {
        this.wd = wd;

        LocalTime currentTime = LocalTime.now();
        boolean isDayTime = currentTime.isAfter(LocalTime.of(6, 0)) && currentTime.isBefore(LocalTime.of(18, 0));
        this.setColors(isDayTime);

        this.initFrame(wd);
    }

    private void initFrame(WeatherDetail wd) {
        setTitle("Weather App");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Define the start and end points for the gradient
                Point2D start = new Point2D.Float(0, 0);
                Point2D end = new Point2D.Float(getWidth(), getHeight());

                // Create the gradient paint object
                GradientPaint gradient = new GradientPaint(start, colors.getPrimaryColor(), end, colors.getSecondaryColor());

                // Set the paint to the graphics context
                g2d.setPaint(gradient);

                // Fill the entire panel with the gradient
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(panel);

        JPanel weatherDetailsPanel = this.getWeatherDetailsPanel();

//        panel.add(this.getSearch(), BorderLayout.NORTH);
        panel.add(weatherDetailsPanel, BorderLayout.CENTER);

        setVisible(true);

    }

    private JPanel getWeatherDetailsPanel() {
        JPanel weatherDetailsPanel = new JPanel(new GridLayout(4, 1));
        weatherDetailsPanel.setOpaque(false);

        Font textFont = new Font("Andalus", Font.PLAIN, 16);

        JLabel timezoneLabel = new JLabel(wd.getTimezone());
        timezoneLabel.setForeground(this.colors.getTextColor());
        timezoneLabel.setFont(new Font("Andalus", Font.PLAIN, 24));
        timezoneLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel temperatureLabel = new JLabel(wd.getTemperatureF());
        temperatureLabel.setForeground(this.colors.getTextColor());
        temperatureLabel.setFont(new Font("Andalus", Font.BOLD, 40));
        temperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        temperatureLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));

        JLabel descriptionLabel = new JLabel(wd.getDescriptionF());
        descriptionLabel.setForeground(this.colors.getTextColor());
        descriptionLabel.setFont(new Font("Andalus", Font.PLAIN, 24));
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel weatherDetailsSubPanel = this.getExtraDetailsPanel(textFont);

        weatherDetailsPanel.add(timezoneLabel);
        weatherDetailsPanel.add(temperatureLabel);
        weatherDetailsPanel.add(descriptionLabel);
        weatherDetailsPanel.add(weatherDetailsSubPanel);

        return weatherDetailsPanel;
    }

    private JPanel getExtraDetailsPanel(Font textFont) {
        JPanel weatherDetailsSubPanel = new JPanel(new GridLayout(2, 3));
        weatherDetailsSubPanel.setOpaque(false); // Make panel transparent

        ListIterator<String> iter = wd.getExtraDetailsF().listIterator();

        while (iter.hasNext()) {
            String next = iter.next();
            JLabel label = new JLabel(next);
            label.setForeground(this.colors.getTextColor());
            label.setFont(textFont);
            label.setHorizontalAlignment(SwingConstants.CENTER);

            weatherDetailsSubPanel.add(label);
        }

        return weatherDetailsSubPanel;
    }

    private void setColors(boolean isDayTime) {
//        long unixTimeSeconds = wd.getCurrent().getDt(); // Unix time in seconds
//        long unixTimeMillis = unixTimeSeconds * 1000L; // Convert seconds to milliseconds
//
//        // Convert Unix time in milliseconds to Instant
//        Instant instant = Instant.ofEpochMilli(unixTimeMillis);
//
//        // Convert Instant to ZonedDateTime specifying UTC timezone
//        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
//
//        // Extract LocalTime from ZonedDateTime
//        LocalTime localTime = zonedDateTime.toLocalTime();


        Color color1;
        Color color2;
        Color textColor = isDayTime ? Color.BLACK : Color.WHITE;

        String description = wd.getDescription();
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

        this.colors = new Colors(color1, color2, textColor);
    }

    private JPanel getSearch() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));
        searchField.setForeground(Color.WHITE);
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchField.setBackground(new Color(52, 73, 94));
        searchField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(189, 195, 199)), // Add bottom border
                BorderFactory.createEmptyBorder(5, 10, 5, 10))); // Add padding
        searchField.setVisible(false);


        // Create a search icon
        ImageIcon searchIcon = new ImageIcon("src/main/java/Weather/static/search.png");
        System.out.println("Icon loaded: " + searchIcon.getImageLoadStatus());
        JButton searchButton = new JButton(searchIcon);
        searchButton.setPreferredSize(new Dimension(30, 30));
        searchButton.setContentAreaFilled(false); // Make the button transparent
        searchButton.setBorderPainted(false); // Remove border
        searchButton.setFocusPainted(false); // Remove focus border
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setVisible(!searchField.isVisible());
                if (searchField.isVisible()) {
                    searchField.requestFocusInWindow();
                }
                pack();
            }
        });

        searchPanel.add(searchButton);
        searchPanel.add(searchField);

        return searchPanel;
    }


}
