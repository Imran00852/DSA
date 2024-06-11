package Arrays;

import java.util.Scanner;

public class RotateAnArray {
    public static void reverse(int arr[], int i, int j) {
        int li = i;
        int ri = j;
        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;

            li++;
            ri--;
        }
    }

    public static void getRotatedArr(int arr[], int k) {

        k = k % arr.length;
        if (k < 0) {
            k = k + arr.length;
        }
        //part1
        reverse(arr, 0, arr.length - k - 1);

        //part2
        reverse(arr, arr.length - k, arr.length - 1);

        //whole reverse
        reverse(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        getRotatedArr(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
