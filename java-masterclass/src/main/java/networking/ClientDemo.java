package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5050)) {
            BufferedReader echo = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            // Write to server
            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string: ");
                echoString = scanner.nextLine();
                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    response = echo.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
