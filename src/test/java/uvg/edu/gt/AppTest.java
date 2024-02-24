package uvg.edu.gt;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

    private Calculator calculator = Calculator.getInstance();

    @Test
    public void testConvertToPostfix() {
        String infix = "(3 + 4) * (5 - 2)";
        String expectedPostfix = "34+52-*";
        assertEquals(expectedPostfix, calculator.convertToPostfix(infix));
    }

    @Test
    public void testEvaluatePostfix() {
        String postfix = "34+52-*";
        int expectedResult = 21;
        assertEquals(expectedResult, calculator.evaluatePostfix(postfix));
    }

    // Aquí puedes agregar más métodos de prueba...
}
