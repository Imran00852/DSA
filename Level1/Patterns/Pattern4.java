package Level1.Patterns;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int space = 0;
        int star = n;
        for (int i = 1; i <= n; i++) {

            //space
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            //star
            for (int k = 1; k <= star; k++) {
                System.out.print("*");
            }
            space++;
            star--;
            System.out.println();
        }
    }
}
