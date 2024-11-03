package Level2.HashMapsAndHeaps;

import java.util.HashSet;

public class ArithmeticSequenceCheck {
    public static boolean checkAP(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            set.add(val);
        }

        int d = (max - min) / (arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            int ai = min + i * d;
            if (!set.contains(ai)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {17, 9, 5, 29, 1, 25, 13, 37, 21, 33};

        System.out.println(checkAP(arr));
    }
}
