package staticdemo;

public class Password {
    private static final int KEY = 2020220;
    private final int encrypted;

    public Password(int pw) {
        this.encrypted = crypt(pw);
    }

    private int crypt(int pw) {
        return pw ^ KEY; // XOR
    }

    public final void storePw() {
        System.out.println("Saving pw as : "+ this.encrypted);
    }

    public boolean logIn(int pw) {
        if (crypt(pw) == this.encrypted) {
            System.out.println("welcome");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }
}
