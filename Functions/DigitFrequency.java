package Functions;

import java.util.Scanner;

public class DigitFrequency {
    public static int digitFreq(int n, int d) {
        int freq = 0;
        while (n != 0) {
            int dig = n % 10;
            n = n / 10;

            if (dig == d) {
                freq++;
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        System.out.print(digitFreq(n, d));
    }
}
