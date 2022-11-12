package networking.highlevelAPI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class ApacheHttpClient {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://example.org");
        request.addHeader("User-Agent", "Chrome");

        try(CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println("Response code: " + response.getStatusLine().getStatusCode());
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent())
            );

            String line;

            while((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
