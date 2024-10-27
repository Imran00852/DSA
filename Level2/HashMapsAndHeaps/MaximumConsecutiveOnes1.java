package Level2.HashMapsAndHeaps;

public class MaximumConsecutiveOnes1 {
    public static int getMaxSubArrWithConsecutiveOnes(int[] arr, int k) {
        int j = -1;
        int count = 0;
        int maxL = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
            //release
            while (count > k) {
                j++;
                if (arr[j] == 0) {
                    count--;
                }
            }

            int len = i - j;
            maxL = Math.max(len, maxL);
        }
        return maxL;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 1, 1, 0, 1};
        System.out.println(getMaxSubArrWithConsecutiveOnes(arr, 3));
    }
}
