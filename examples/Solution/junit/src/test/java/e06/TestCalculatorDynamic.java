package e06;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import e01.Calculator;

public class TestCalculatorDynamic {

/*	private static Calculator c;
	
	@BeforeAll
	public static void setUp() {
		c = new Calculator();
	}
	
	@TestFactory
    public List<DynamicTest> testAdd() {
        List<DynamicTest> myTests = new LinkedList<DynamicTest>();
        
        myTests.add(dynamicTest("Test add of 1 and 1", () -> {
        	double input = 1;
        	double expected = 2;
        	double actual = c.add(input, input);
        	assertEquals(expected, actual);
        }));

        return myTests;
    }
	
	@TestFactory
    public Stream<DynamicTest> testAddDynamic() {
        List<Double> inputNumbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> expectedNumbers = Arrays.asList(2.0, 4.0, 6.0, 8.0, 10.0);

        return IntStream.range(0, inputNumbers.size())
            .mapToObj(index -> dynamicTest("Test add of " + inputNumbers.get(index) + " and " + + inputNumbers.get(index), () -> {
                double input = inputNumbers.get(index);
                double expected = expectedNumbers.get(index);
                double actual = c.add(input, input);
                assertEquals(expected, actual, "The sum of " + input + " and " + input + " should be " + expected);
            }));
    }
	
	
    @TestFactory
    public Stream<DynamicTest> testSquareDynamic() {
        List<Double> inputNumbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> expectedSquares = Arrays.asList(1.0, 4.0, 9.0, 16.0, 25.0);

        return IntStream.range(0, inputNumbers.size())
            .mapToObj(index -> dynamicTest("Test square of " + inputNumbers.get(index), () -> {
                double input = inputNumbers.get(index);
                double expected = expectedSquares.get(index);
                double actual = c.square(input);
                assertEquals(expected, actual, "The square of " + input + " should be " + expected);
            }));
    }*/
}
