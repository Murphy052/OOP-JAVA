package Weather.ui;

import Weather.weather.WeatherDetail;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

/**
 * This class represents the user interface of the weather application and acts as main user interface.
 * It displays weather details and provides functionality for refreshing data and searching for weather by city.
 */
public class AppUI extends JFrame {

    private WeatherDetail wd; // Weather details
    private JPanel weatherDetailsPanel; // Panel to display weather details
    private JTextField searchField; // Text field for searching by city
    private JButton searchButton; // Button to toggle visibility of search field
    private Colors colors; // Colors for UI elements
    private String token; // API token for accessing weather data

    /**
     * Constructs an instance of the AppUI class.
     *
     * @param wd    Weather details to display.
     * @param token API token for accessing weather data.
     */
    public AppUI(WeatherDetail wd, String token) {
        this.wd = wd;
        this.token = token;
        this.colors = new Colors(this.wd.isDaytime(), this.wd.getDescription());

        this.initFrame();
    }

    /**
     * Initializes the frame and sets up the user interface components.
     */
    private void initFrame() {
        setTitle("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout()) {
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

        this.weatherDetailsPanel = WeatherDetailsPanel.createPanel(this.wd, this.colors);
        JButton refreshButton = RefreshButton.createButton();
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWeatherDetail();
                // Repaint the frame to reflect the changes
                revalidate();
                repaint();
            }
        });

        JPanel search = this.createSearch();
        this.searchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Get the text from the searchField
                    String searchText = searchField.getText();

                    // Run your function here, using the searchText variable
                    System.out.println("Searching for: " + searchText);

                    searchUpdateWeatherDetail(searchText);

                    revalidate();
                    repaint();
                }
            }
        });


        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setOpaque(false);
        northPanel.add(search, BorderLayout.WEST); // Add search panel to the left
        northPanel.add(refreshButton, BorderLayout.EAST); // Add top panel to the right

        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(this.weatherDetailsPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    /**
     * Updates the weather details by fetching data from the API.
     */
    private void updateWeatherDetail() {
        try {
            this.wd = WeatherDetail.get_weather_detail(this.token);
        } catch (JsonProcessingException e) {
            System.exit(-1);
        }
        this.colors = new Colors(this.wd.isDaytime(), this.wd.getDescription());
        getContentPane().remove(this.weatherDetailsPanel);
        JPanel weatherDetailsPanel = WeatherDetailsPanel.createPanel(this.wd, this.colors);

        getContentPane().add(weatherDetailsPanel);
    }

    /**
     * Updates the weather details by fetching data for the specified city from the API.
     *
     * @param city The city for which weather details are to be fetched.
     */
    private void searchUpdateWeatherDetail(String city) {
        try {
            this.wd = WeatherDetail.get_weather_detail_by_city(this.token, city);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        this.colors = new Colors(this.wd.isDaytime(), this.wd.getDescription());
        getContentPane().remove(this.weatherDetailsPanel);
        JPanel weatherDetailsPanel = WeatherDetailsPanel.createPanel(this.wd, this.colors);

        getContentPane().add(weatherDetailsPanel);
    }

    /**
     * Creates the search panel containing the search field and search button.
     *
     * @return The panel containing the search components.
     */

    private JPanel createSearch() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setOpaque(false);

        this.searchField = new JTextField();
        this.searchField.setPreferredSize(new Dimension(200, 30));
        this.searchField.setForeground(Color.WHITE);
        this.searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        this.searchField.setBackground(new Color(52, 73, 94));
        this.searchField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(189, 195, 199)), // Add bottom border
                BorderFactory.createEmptyBorder(5, 10, 5, 10))); // Add padding
        this.searchField.setVisible(false);

        // Create a search icon
        Image img = new ImageIcon("src/main/java/Weather/static/search.png").getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        this.searchButton = new JButton(new ImageIcon(img));
        this.searchButton.setPreferredSize(new Dimension(30, 30));
        this.searchButton.setContentAreaFilled(false); // Make the button transparent
        this.searchButton.setBorderPainted(false); // Remove border
        this.searchButton.setFocusPainted(false); // Remove focus border
        this.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setVisible(!searchField.isVisible());
                if (searchField.isVisible()) {
                    searchField.requestFocusInWindow();
                }
                pack();
            }
        });

        searchPanel.add(this.searchButton);
        searchPanel.add(this.searchField);

        return searchPanel;
    }
}
