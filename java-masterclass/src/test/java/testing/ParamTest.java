package testing;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamTest {

    private ToBeTested underTest;
    private double amount;
    private double expected;

    public ParamTest(double amount, double expected) {
        this.amount = amount;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        underTest = new ToBeTested("Kalle Anka", 100, 230.00);
    }


    @org.junit.Test
    public void deposit() {
        underTest.deposit(amount, false);
        assertEquals(expected, underTest.getSaldo(), 0);
    }


    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{
                {100, 330.00},
                {200, 430.00},
        });
    }
}
