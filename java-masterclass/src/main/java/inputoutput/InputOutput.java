package inputoutput;

import java.io.IOException;

public class InputOutput {
    public static Locations locations = new Locations();
    public static void main(String[] args) {

        System.out.println(locations.entrySet());

        try {
            locations.loadMap();
            locations.putLoadInYoMoma();
            locations.writeWithBufferedWriter();
        } catch (IOException e) {
            System.out.println("Shit!");
        }

        locations.readFile();

    }
}
