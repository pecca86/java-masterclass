package networking.highlevelAPI;

import org.sqlite.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HttpUrlConnWithParams {
    public static void main(String[] args) {
        try {
            // URL CONNECTION
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            connection.setReadTimeout(3000);

            if (responseCode != 200) {
                System.out.println("Connection failed!");
            }

            BufferedReader is = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = is.readLine()) != null) {
                System.out.println(line);
            }
            is.close();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

