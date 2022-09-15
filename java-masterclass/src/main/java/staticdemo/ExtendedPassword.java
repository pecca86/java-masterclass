package staticdemo;

public class ExtendedPassword extends Password {
    private int decryptedPw;

    public ExtendedPassword(int pw) {
        super(pw);
        this.decryptedPw = pw;
    }

    // Cannot not be declared, since the method is final
//    @Override
//    public void storePw() {
//        System.out.println("Saving pw as : " + this.decryptedPw);
//    }
}
