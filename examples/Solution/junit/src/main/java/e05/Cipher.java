package e05;

public class Cipher {

    public static String encode(String input) {
    	if (input == null) {
    		return null;
    	}
    	String output = "";
    	for (char c : input.toCharArray()) {
    		output = output + (char)(c + 3);
    	}
    	return output;
    }
	
    
    public static String decode(String input) {
    	if (input == null) {
    		return null;
    	}
    	String output = "";
    	for (char c : input.toCharArray()) {
    		output = output + (char)(c - 3);
    	}
    	return output;
    }
    
}
