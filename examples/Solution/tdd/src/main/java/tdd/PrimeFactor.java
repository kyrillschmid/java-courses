package tdd;

import java.util.ArrayList;

public class PrimeFactor {
	
	public static ArrayList<Integer> generate(int n){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int factor = 2; factor <= n; factor++) {
			while(n % factor == 0) {
				result.add(factor);
				n = n/factor;
			}
		}
		return result;
	}
	
	// auch mittels TDD lösen
	public static boolean isPrime(int n) {
		return true;
	}

}
