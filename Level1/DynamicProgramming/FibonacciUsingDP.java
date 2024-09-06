package Level1.DynamicProgramming;

public class FibonacciUsingDP {
    public static int fib(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int fbnm1 = fib(n - 1, qb);
        int fbnm2 = fib(n - 2, qb);
        int fibn = fbnm1 + fbnm2;
        qb[n] = fibn;
        return fibn;
    }

    public static void main(String[] args) {
        System.out.println(fib(6, new int[7]));
    }
}
