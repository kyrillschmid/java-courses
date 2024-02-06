package e01;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import e01.Calculator;

 
public class CalculatorTest {
    
    @Test
    public void testAddition() {
    	Calculator calculator = new Calculator();
        double actual = calculator.add(2, 3);
        double expected = 5;
        assertEquals(actual, expected, "2 + 3 should equal 5");
    }

    @Test
    public void testSubtraction() {
    	Calculator calculator = new Calculator();
        double actual = calculator.subtract(5, 2);
        double expected = 3; 
        assertEquals(actual, expected, "5 - 2 should equal 3");
    }
    
    @Test
    public void testDivision() {
    	Calculator calculator = new Calculator();
    	double actual = calculator.divide(10, 5);
    	double expected = 2;
    	assertEquals(actual, expected,  "10 / 5 should equal 2");
    }
    
    @Test
    public void testMultiplication() {
    	Calculator calculator = new Calculator();
    	double actual = calculator.multiply(10, 5);
    	double expected = 50;
    	assertEquals(actual, expected,  "10 * 5 should equal 50");
    }
}
