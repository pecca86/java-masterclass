package testing;

public class ToBeTested {
    private String name;
    private Integer age;
    private Double saldo;

    public ToBeTested(String name, Integer age, Double saldo) {
        this.name = name;
        this.age = age;
        this.saldo = saldo;
    }

    public double deposit(double amount, boolean branch) {
        saldo += amount;
        return saldo;
    }

    public double withdraw(double amount, boolean branch) {
        saldo -= amount;
        return saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void robBankAccount() throws IllegalAccessException {
        throw new IllegalAccessException("NO SIR NOT TODAY!");
    }
}
