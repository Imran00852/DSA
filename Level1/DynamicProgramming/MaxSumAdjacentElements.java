package Level1.DynamicProgramming;

public class MaxSumAdjacentElements {
    public static void getMaxSum(int[] arr) {
        int inc = arr[0];
        int exc = 0;

        for (int i = 1; i < arr.length; i++) {
            int nInc = exc + arr[i];
            int nExc = Math.max(inc, exc);

            inc = nInc;
            exc = nExc;
        }

        System.out.println(Math.max(inc, exc));
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 10, 100, 5, 6};
        getMaxSum(arr);
    }
}
