package Functions;

import java.util.Scanner;

public class AnyBaseToDecimal {
    public static int anyBaseToDecimal(int n, int b) {
        int res = 0;
        int p = 1; //8 to the power 0
        while (n != 0) {
            int dig = n % 10;
            n = n / 10;

            res += dig * p;
            p = p * b;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(anyBaseToDecimal(d, b));
    }
}
