package innerabstractinterfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SaveDemo {
    public static void main(String[] args) {


        HardDrive hd = new HardDrive();

        Game turtles = new Game("Teenage Mutant Ninja Turtles 1", "Fighting", hd);
        Game turtles1 = new Game("Teenage Mutant Ninja Turtles 1", "Fighting", hd);

        turtles1.setLevel(10);

        turtles.save();
        turtles1.save();

        System.out.println(hd);
    }
}
