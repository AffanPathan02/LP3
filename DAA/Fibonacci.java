public class Fibonacci {
    public static long recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

  public static long iterativeFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long fib1 = 0;
        long fib2 = 1;
        long fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        return fib;
    }
    public static void main(String[] args) {
        int n = 10; // Change n to the desired Fibonacci number.
        long result = recursiveFibonacci(n);
        System.out.println("Fibonacci(" + n + ") = " + result);

      long result = iterativeFibonacci(n);
        System.out.println("Fibonacci(" + n + ") = " + result);
    }
}
