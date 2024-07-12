package Level1.Functions;

import java.util.Scanner;

public class DecimalToAnyBase {
    public static int decimalToAnyBase(int n, int b) {
        int res = 0;

        int p = 1;
        while (n != 0) {
            int dig = n % b;
            n = n / b;

            res += dig * p;
            p *= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(decimalToAnyBase(d, b));
    }
}
