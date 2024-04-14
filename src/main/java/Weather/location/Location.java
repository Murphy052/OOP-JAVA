package Weather.location;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class Location {
    private String ip;
    private double latitude;
    private double longitude;
    static String checkIpUrl = "http://checkip.amazonaws.com/";

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

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
