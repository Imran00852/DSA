package Level1.Arrays;

import java.util.Scanner;

public class FindElementInAnArray {
    public static int findElement(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        if (findElement(arr, key) == -1) {
            System.out.println("Key not found");
        } else {
            System.out.println("Index of" + " " + key + " " + "is" + " " + findElement(arr, key));
        }
    }
}
