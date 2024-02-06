package e03;

public class StringFormatter {

	    public static String capitalize(String input) {
	        if (input == null) {
	            return null;
	        }
	        return input.toUpperCase();
	    }
	    
	    public static boolean isEmpty(String input) {
	    	if (input.length() == 0) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }

	    public static String truncate(String input, int length) {
	        if (input == null) {
	            return null;
	        }
	        if (length <= 0) {
	            throw new IllegalArgumentException("Length must be non negative");
	        }
	        if (input.length() <= length) {
	            return input;
	        }
	        return input.substring(0, length);
	    }
	
	    public static String reverse(String input) {
	    	if (input == null) {
	    		return null;
	    	}
	    	return new StringBuilder(input).reverse().toString();
	    }
	
	    
}
