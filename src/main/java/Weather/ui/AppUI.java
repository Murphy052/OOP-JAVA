package Weather.ui;

import Weather.weather.WeatherDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class AppUI extends JFrame {

    private WeatherDetail wd;
    private JPanel weatherDetailsPanel;
    private Colors colors;

    public AppUI(WeatherDetail wd) {
        this.wd = wd;

        this.colors = new Colors(!this.wd.isDaytime(), this.wd.getDescription());

        this.initFrame();
    }

    private void initFrame() {
        setTitle("Weather App");
//        setSize(800, 400);
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

        JPanel weatherDetailsPanel = WeatherDetailsPanel.createPanel(this.wd, this.colors);
        JButton refreshButton = RefreshButton.createButton();

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Repaint the frame to reflect the changes
                revalidate();
                repaint();
            }
        });

//        panel.add(this.getSearch(), BorderLayout.NORTH);
        panel.add(weatherDetailsPanel, BorderLayout.CENTER);
//        panel.add(refreshButton, BorderLayout.EAST);

        pack();
        setVisible(true);
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
