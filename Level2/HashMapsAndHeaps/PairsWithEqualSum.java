package Level2.HashMapsAndHeaps;

import java.util.HashSet;

public class PairsWithEqualSum {
    public static boolean checkIfAPairWithEqualSumExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (set.contains(sum)) {
                    return true;
                } else {
                    set.add(sum);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 8, 1, 2, 6, 3};
        System.out.println(checkIfAPairWithEqualSumExist(arr));
    }
}
