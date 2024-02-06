package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// How to get the square sum of all even numbers?
		
		// Classic
		/*
		List<Integer> squares = new ArrayList<Integer>();
		for(Integer x : numbers) {
			if(x % 2 == 0) {
				squares.add(x*x);
			}
		}
		for(Integer x : squares) {
			System.out.println(x);
		}
		*/
		
		
		//numbers.stream()
		//		.filter(x -> x % 2 == 0)
		//		.map(x -> x*x)
		//		.forEach(x -> System.out.println(x));
		
		/*
		IntStream.iterate(0, n -> n + 1)
			.filter(x -> x % 2 == 0)
			.map(x -> x*x)
			.limit(100)
			.forEach(x -> System.out.println(x));
		
	*/
	
		// Summe bilden
		int sum = 0;
		for(int i : numbers) {
			if (i % 2 == 0) {
				int m = i + 3;
				System.out.println(m);
				sum += m;
			}
		}
		System.out.println(sum);
		
		int sumStream = numbers.stream()
					.filter(x -> x % 2 == 0)
					.map(x -> x + 3)
					.mapToInt(x -> x.intValue())
					.sum();
		System.out.println(sumStream);
	
	
	}
	

}
