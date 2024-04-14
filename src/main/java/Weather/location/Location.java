package Weather.location;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * This class retrieves the user's current location information (latitude and longitude) based on their IP address.
 * It utilizes the MaxMind GeoIP2 library to get location data from a local GeoLite2 City database.
 */
public class Location {

    /**
     * The user's IP address retrieved from a public service.
     */
    private String ip;

    /**
     * The user's latitude coordinate.
     */
    private double latitude;

    /**
     * The user's longitude coordinate.
     */
    private double longitude;

    /**
     * URL used to retrieve the user's public IP address.
     */
    static final String checkIpUrl = "http://checkip.amazonaws.com/";

    /**
     * Default constructor that retrieves the user's location upon object creation.
     *
     * - Fetches the user's public IP address from a public service.
     * - Uses the IP address to query a local GeoLite2 City database for location data using MaxMind GeoIP2 library.
     * - Extracts latitude and longitude from the response and stores them in the object.
     *
     * Catches any exceptions during the process, prints the stack trace, and exits the program with an error code (-1).
     */
    public Location() {
        try {
            URL url = new URL(checkIpUrl);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                this.ip = br.readLine();
            }

            String dbLocation = "src/main/java/Weather/static/CityDB/GeoLite2-City.mmdb";
            File database = new File(dbLocation);
            DatabaseReader dbReader = new DatabaseReader.Builder(database).build();

            InetAddress ipAddress = InetAddress.getByName(this.ip);
            CityResponse response = dbReader.city(ipAddress);

            this.latitude = response.getLocation().getLatitude();
            this.longitude = response.getLocation().getLongitude();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Returns the user's latitude coordinate.
     * @return The latitude value as a double.
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Returns the user's longitude coordinate.
     * @return The longitude value as a double.
     */
    public double getLongitude() {
        return this.longitude;
    }
}
