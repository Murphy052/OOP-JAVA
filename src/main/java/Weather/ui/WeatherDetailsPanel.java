package Weather.ui;

import Weather.weather.Daily;
import Weather.weather.WeatherDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ListIterator;

/**
 * This class is responsible for creating a weather details panel that displays information about the current weather and daily forecast.
 * It utilizes a `Colors` object to define the text color based on the current theme.
 */
public class WeatherDetailsPanel {

    /**
     * Creates a weather details panel with information about the current weather and daily forecast.
     *
     * @param wd The `WeatherDetail` object containing current weather data and daily forecast. (required)
     * @param colors The `Colors` object defining the text color for the panel elements. (required)
     * @return A `JPanel` representing the weather details panel.
     */
    public static JPanel createPanel(WeatherDetail wd, Colors colors) {
        JPanel weatherDetailsPanel = new JPanel(new BorderLayout());
        weatherDetailsPanel.setOpaque(false);

        JPanel mainDetailsPanel = createMainDetailsPanel(wd, colors);
        JPanel extraDetailsPanel = createExtraDetailsPanel(wd, colors);
        JPanel dailyPanel = createDailyPanel(wd, colors);

        weatherDetailsPanel.add(mainDetailsPanel, BorderLayout.NORTH);
        weatherDetailsPanel.add(extraDetailsPanel, BorderLayout.CENTER);
        weatherDetailsPanel.add(dailyPanel, BorderLayout.SOUTH);

        return weatherDetailsPanel;
    }

    /**
     * Creates a sub-panel displaying the location (timezone), current temperature, and weather description.
     *
     * @param wd The `WeatherDetail` object containing current weather data. (required)
     * @param colors The `Colors` object defining the text color for the panel elements. (required)
     * @return A `JPanel` representing the main details panel.
     */
    private static JPanel createMainDetailsPanel(WeatherDetail wd, Colors colors) {
        JPanel mainDetailsPanel = new JPanel(new GridLayout(3, 1));
        mainDetailsPanel.setOpaque(false);

        Font textFont = new Font("Andalus", Font.PLAIN, 16);

        JLabel timezoneLabel = new JLabel(wd.getTimezone());
        timezoneLabel.setForeground(colors.getTextColor());
        timezoneLabel.setFont(new Font("Andalus", Font.PLAIN, 24));
        timezoneLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel temperatureLabel = new JLabel(wd.getTemperatureF());
        temperatureLabel.setForeground(colors.getTextColor());
        temperatureLabel.setFont(new Font("Andalus", Font.BOLD, 40));
        temperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        temperatureLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));

        JLabel descriptionLabel = new JLabel(wd.getDescriptionF());
        descriptionLabel.setForeground(colors.getTextColor());
        descriptionLabel.setFont(new Font("Andalus", Font.PLAIN, 24));
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mainDetailsPanel.add(timezoneLabel);
        mainDetailsPanel.add(temperatureLabel);
        mainDetailsPanel.add(descriptionLabel);

        return mainDetailsPanel;
    }

    /**
     * Creates a sub-panel displaying additional weather details like humidity, wind speed, etc.
     *
     * @param wd The `WeatherDetail` object containing current weather data. (required)
     * @param colors The `Colors` object defining the text color for the panel elements. (required)
     * @return A `JPanel` representing the extra details panel.
     */
    private static JPanel createExtraDetailsPanel(WeatherDetail wd, Colors colors) {
        JPanel extraDetailsPanel = new JPanel(new GridLayout(2, wd.getExtraDetailsF().size() / 2));
        extraDetailsPanel.setOpaque(false);

        Font textFont = new Font("Andalus", Font.PLAIN, 16);

        ListIterator<String> iter = wd.getExtraDetailsF().listIterator();

        while (iter.hasNext()) {
            String next = iter.next();
            JLabel label = new JLabel(next);
            label.setForeground(colors.getTextColor());
            label.setFont(textFont);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            extraDetailsPanel.add(label);
        }

        return extraDetailsPanel;
    }

    /**
    * Creates a sub-panel displaying the daily forecast for the next few days.
    *
    * @param wd The `WeatherDetail` object containing daily forecast data. (required)
    * @param colors The `Colors` object defining the text
    * @param colors The `Colors` object defining the text color for the panel elements. (required)
    * @return A `JPanel` representing the daily forecast panel.
    */
    private static JPanel createDailyPanel(WeatherDetail wd, Colors colors) {
        JPanel dailyPanel = new JPanel(new GridLayout(1, wd.getDaily().size()));
        dailyPanel.setOpaque(false);
        dailyPanel.setBorder(BorderFactory.createEmptyBorder(40, 10, 40, 10));

        ListIterator<Daily> iter = wd.getDaily().listIterator();

        while (iter.hasNext()) {
            Daily next = iter.next();
            JPanel dailyDetailsPanel = createDailyDetailsPanel(next, colors);
            dailyPanel.add(dailyDetailsPanel);
        }

        return dailyPanel;
    }

    /**
     * Creates a sub-panel for each day in the daily forecast, displaying the date, temperature, and weather description.
     *
     * @param daily The `Daily` object containing forecast data for a single day. (required)
     * @param colors The `Colors` object defining the text color for the panel elements. (required)
     * @return A `JPanel` representing a single day's forecast details.
     */
    private static JPanel createDailyDetailsPanel(Daily daily, Colors colors) {
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();
                float opacity = 0.4f;
                Color bgColor = new Color(255, 255, 255, (int) (255 * opacity));
                g2d.setPaint(bgColor);
                // Increase the height of the translucent rectangle
                g2d.fill(new RoundRectangle2D.Double(0, 0, width - 8, height, 10, 10));
                g2d.dispose();
            }
        };

        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel timeLabel = new JLabel(daily.getTimeF());
        timeLabel.setForeground(colors.getTextColor());
        timeLabel.setFont(new Font("Andalus", Font.PLAIN, 12));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel temperatureLabel = new JLabel(daily.getTemperatureF());
        temperatureLabel.setForeground(colors.getTextColor());
        temperatureLabel.setFont(new Font("Andalus", Font.BOLD, 20));
        temperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        temperatureLabel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));

        JLabel descriptionLabel = new JLabel(daily.getDescriptionF());
        descriptionLabel.setForeground(colors.getTextColor());
        descriptionLabel.setFont(new Font("Andalus", Font.PLAIN, 12));
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(timeLabel, BorderLayout.NORTH);
        panel.add(temperatureLabel, BorderLayout.CENTER);
        panel.add(descriptionLabel, BorderLayout.SOUTH);

        panel.setOpaque(false);

        return panel;
    }
}
