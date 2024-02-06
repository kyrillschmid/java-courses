package e05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import e01.Calculator;

public class CalculatorParameterizedTest {
	
/*
    @ParameterizedTest
    @CsvSource({"2, 4", "3, 9", "4, 16", "5, 25"})
    public void testSquareMultipleInputs(double input, double expected) {
    	Calculator c = new Calculator();
    	assertEquals(c.square(input), expected, "Square of " + input + " should be " + (input * input));
    }
    
    
	@ParameterizedTest
	@MethodSource("inputProviderSquare")
	public void testSquareMultipleInputsMethodSource(double input_a, double expected) {
		System.out.println(input_a + " " + expected);
		Calculator c = new Calculator();
		double actual = c.square(input_a);
		assertEquals(expected, actual);	
	}
	
	static List<String[]> inputProviderSquare() {
		return Arrays.asList(new String[][] {
			{"3.0", "9.0"},
			{"4.0", "16.0"},
			{"5.0", "25.0"},
		});
	}
    
    
	@ParameterizedTest
	@MethodSource("inputProviderDivide")
	public void testDivideMultipleInputs(double input_a, double input_b, double expected) {
		System.out.println(input_a + " " + expected);
		Calculator c = new Calculator();
		double actual = c.divide(input_a, input_b);
		assertEquals(expected, actual);	
	}
	
	static List<String[]> inputProviderDivide() {
		return Arrays.asList(new String[][] {
			{"10.0", "5", "2.0"},
			{"21.0", "7", "3.0"},
			{"49.0", "7", "7.0"},
		});
	}
*/

}
