package Level2.HashMapsAndHeaps;

import java.util.HashSet;

public class LengthOfMaxContigiousSubarray {
    public static int getLengthOfMaxContSubarr(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int max = arr[i];
            int min = arr[i];
            HashSet<Integer> checkDuplicates = new HashSet<>();
            checkDuplicates.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (checkDuplicates.contains(arr[j])) break;
                checkDuplicates.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if (max - min == j - i) {
                    int len = j - i + 1;
                    maxLen = Math.max(len, maxLen);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 7, 5, 6, 23, 24, 22, 23, 19, 17, 16, 18, 39, 0};
        System.out.println(getLengthOfMaxContSubarr(arr));

    }
}
