package Level1.Patterns;

import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sp = n / 2;
        int st = 1;

        int val = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }
            int cval = val;
            for (int k = 1; k <= st; k++) {
                System.out.print(cval);
                if (k <= st / 2) {
                    cval++;
                } else {
                    cval--;
                }
            }

            if (i <= n / 2) {
                st += 2;
                sp--;
                val++;
            } else {
                st -= 2;
                sp++;
                val--;
            }

            System.out.println();
        }
    }
}
