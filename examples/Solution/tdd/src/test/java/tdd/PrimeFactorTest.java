package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;



public class PrimeFactorTest {
	
	@Test
	void generateGiven1() {
		assertEquals(new ArrayList<Integer>(), PrimeFactor.generate(1));
	}
	
	@Test 
	void generateGiven2() {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		assertEquals(expected, PrimeFactor.generate(2));
	}
	
	@Test 
	void generateGiven3() {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(3);
		assertEquals(expected, PrimeFactor.generate(3));
	}
	
	@Test 
	void generateGiven4() {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		expected.add(2);
		assertEquals(expected, PrimeFactor.generate(4));
	}

	private static IntStream numberGenerator() {
		return IntStream.range(2, 10000);
	}

	@ParameterizedTest
	@MethodSource("numberGenerator")
	void generateGivenN(int n) {
		List<Integer> factors = PrimeFactor.generate(n);
		int product = 1;
		for (int factor : factors) {
			// assertTrue(PrimeFactor.isPrime(factor)); -> also discover through TDD
			product = product * factor;
		}
		assertEquals(n, product);
	}

}
