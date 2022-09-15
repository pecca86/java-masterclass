package flow;

public class ForSkin {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Farting times: " + farts(i));
        }
    }


    public static int farts(int anusSize) {
        if (anusSize > 9) {
            return anusSize * 11;
        }

        return anusSize * 5;
    }
}
