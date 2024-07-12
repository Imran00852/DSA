package Level1.Arrays;

import java.util.Scanner;

public class InverseAnArray {
    public static int[] inverse(int arr[]) {
        int inv[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            inv[element] = i;
        }

        return inv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] inv = inverse(arr);
        for (int i = 0; i < inv.length; i++) {
            System.out.print(inv[i] + " ");
        }
    }
}
