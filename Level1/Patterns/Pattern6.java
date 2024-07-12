package Level1.Patterns;

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int st = (n / 2) + 1;
        int sp = 1;

        for (int i = 1; i <= n; i++) {
            //star
            for (int j = 1; j <= st; j++) {
                System.out.print("*");
            }
            //space
            for (int k = 1; k <= sp; k++) {
                System.out.print(" ");
            }
            //star
            for (int l = 1; l <= st; l++) {
                System.out.print("*");
            }
            if (i <= (n / 2)) {
                sp += 2;
                st--;
            } else {
                sp -= 2;
                st++;
            }
            System.out.println();
        }
    }
}
