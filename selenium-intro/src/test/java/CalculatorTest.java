import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    public static final int FIRST_NUMBER = 2;
    public static final int SECOND_NUMBER = 3;

    private int correctExpectedResult = 5;
    private int incorrectExpectedResult = 6;

    int result = calculator.add(FIRST_NUMBER, SECOND_NUMBER);

    @Test
    public void sumTrueTest() {
        assertTrue(result == correctExpectedResult);
    }

    @Test
    public void sumFalseTest() {
        assertFalse(result == incorrectExpectedResult);
    }

    @Test
    public void sumEqualsTest() {
        assertEquals(result, correctExpectedResult);
    }
}
