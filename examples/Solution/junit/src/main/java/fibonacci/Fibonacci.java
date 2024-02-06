package fibonacci;

public class Fibonacci {


    public static long iterativeFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }
    
    public static long recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static void main(String[] args) {
       System.out.println(iterativeFibonacci(50)); // 55
        
       //System.out.println(recursiveFibonacci(15)); // 55
    }

}
