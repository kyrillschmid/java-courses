package e02;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double divide(double a, double b) {
    	return a / b;
    }
    
    public double multiply(double a, double b) {
    	return a * b;
    }
    
    public double square(double a) {
    	return a * a;
    }
    
    
    public static void main(String[] args) {
    	System.out.println(new Calculator().divide(10, 0));
    }

}

