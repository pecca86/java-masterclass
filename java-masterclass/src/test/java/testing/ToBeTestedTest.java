package testing;

import java.util.Optional;

import static org.junit.Assert.*;

public class ToBeTestedTest {

    ToBeTested underTest;

    @org.junit.Before
    public void setUp() throws Exception {
        underTest = new ToBeTested("Pekka", 35, 24000.00);
    }

    @org.junit.Test
    public void deposit() {
        Double returnedSaldo = underTest.deposit(1000, true);
        assertEquals(25000, underTest.getSaldo(), 0);
        assertEquals(25000, returnedSaldo, 0);
    }

    @org.junit.Test
    public void withdraw() {
        Double saldo = underTest.withdraw(24000, true);
        assertEquals(0, underTest.getSaldo(), 0);

        underTest.withdraw(1000, true);
        assertEquals(-1000, underTest.getSaldo(), 0);
    }

    @org.junit.Test
    public void getSaldo() {
        assertEquals(24000, underTest.getSaldo(), 0);
    }
}