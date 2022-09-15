package innerclasses;

import java.util.Scanner;

public class InnerDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btn = new Button("Submit");

    public static void main(String[] args) {
        Gearbox gearbox = new Gearbox();
        Gearbox.Gear n = gearbox.new Gear(0); // Since Gear is an inner class

        // Having a private inner class
        gearbox.addPrivateGear(-1, "R");
        System.out.println(gearbox);

        // implement Inner interface of Button (onclicklistener)
        class ClickListener implements Button.OnClickListener {

            public ClickListener() {
                System.out.println("Button listening");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked!");
            }
        }

        // Create a button using the click listener
        btn.setOnClickListener(new ClickListener());
        btn.onClick();


        // ANONYMOUS CLASS (AKA. LAMBDA)
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was mf clicked!");
            }
        });
        btn.onClick();

        btn.setOnClickListener((e) -> System.out.println(e + " Kakka"));
        btn.onClick();

    }
}
