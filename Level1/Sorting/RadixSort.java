package Level1.Sorting;

public class RadixSort {

    public static void radixSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }

        int exp = 1;
        while (exp <= max) {
            countingSort(arr, exp);
            exp = exp * 10;
        }
    }

    public static void countingSort(int arr[], int exp) {

        //frequency array
        int farr[] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] / exp % 10;
            farr[idx]++;
        }

        //make prefix array from frequency array
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }
        //ans array
        int ans[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i] / exp % 10;
            int pos = farr[val];
            int idx = pos - 1;
            ans[idx] = arr[i];
            farr[val]--;
        }

        //copy ans in our original array arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {213, 69, 712, 64, 94, 84};

        radixSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
