package staticdemo;

public class PasswordDemo {

    public static void main(String[] args) {

        Password pw = new ExtendedPassword(1337);
        pw.storePw();

        pw.logIn(3333);
        pw.logIn(1337);
    }
}
