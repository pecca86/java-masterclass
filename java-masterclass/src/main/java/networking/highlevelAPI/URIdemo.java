package networking.highlevelAPI;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIdemo {
    public static void main(String[] args) {
        try {
            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI relativeUri = new URI("/catalogue/phones?os=android#samsung");
            URI httpUri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI baseUri = new URI("http://www.homot.fi");
            URI resolvedURI = baseUri.resolve(relativeUri);
            URL homoURL = resolvedURI.toURL();
            System.out.println("Visit: " + homoURL);

            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Scheme-specific part: " + uri.getSchemeSpecificPart());
            System.out.println("Authority: " + uri.getAuthority());
            System.out.println("User info: " + uri.getUserInfo());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());

            // CONVERT TO URL
            URL url = httpUri.toURL(); // URI must be absolute for it to be converted into URL
            System.out.println("URL: " + url);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
