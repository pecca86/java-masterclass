package networking.highlevelAPI;

import org.sqlite.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.Buffer;
import java.util.List;
import java.util.Map;

public class URLConnections {
    public static void main(String[] args) {
        try {
            URI baseUri = new URI("http://www.homot.fi");
            URI relativeUri1 = new URI("/catalogue/phones?os=android#samsung");
            URI relativeUri2 = new URI("/catalogue/tvs?brand=philips#hue");
            URI relativeUri3 = new URI("/catalogue/dildos?size=50cm#black");

            URI resolvedUri1 = baseUri.resolve(relativeUri1);
            URI resolvedUri2 = baseUri.resolve(relativeUri2);
            URI resolvedUri3 = baseUri.resolve(relativeUri3);

            URL url1 = resolvedUri1.toURL();
            System.out.println("URL 1 = " + url1);

            URL url2 = resolvedUri2.toURL();
            System.out.println("URL 2 = " + url2);

            URL url3 = resolvedUri3.toURL();
            System.out.println("URL 3 = " + url3);

            URI relativizedURI = baseUri.relativize(resolvedUri1);
            System.out.println("Relative URI = " + relativizedURI);


            // URL CONNECTION
            URL url = new URL("http://www.google.fi");
            // Automatically opens a socket and creates a connection
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String line = "";
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();

            System.out.println("===== CONNECTION WITH URLConnection ======");
            // CONNECTION USING URLConnection
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader is = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            String line2 = "";
            while (line2 != null) {
                line2 = is.readLine();
                System.out.println(line2);
            }
            is.close();


            System.out.println("======== CONNECTION USING HTTPUrlConnection ==========");
            Map<String, List<String>> headerFields =  urlConnection.getHeaderFields();
            headerFields.entrySet()
                    .stream()
                    .forEach(e -> {
                        System.out.println("================================");
                        System.out.println("KEY: " + e.getKey());
                        e.getValue().stream().forEach(v -> System.out.println("VALUE: " + v));
                    });


        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
