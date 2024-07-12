package Level1.Patterns;

import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sp = n / 2;
        int st = 1;
        for (int i = 1; i <= n; i++) {
            //space
            for (int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }
            //star
            for (int k = 1; k <= st; k++) {
                System.out.print("*");
            }
            if (i <= n / 2) {
                sp--;
                st += 2;
            } else {
                sp++;
                st -= 2;
            }
            System.out.println();
        }
    }
}
