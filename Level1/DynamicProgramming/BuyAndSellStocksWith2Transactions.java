package Level1.DynamicProgramming;

public class BuyAndSellStocksWith2Transactions {
    public static void main(String[] args) {
        int[] arr = {30, 40, 43, 50, 45, 20, 26, 40, 80, 50, 30, 15, 10, 20, 40, 45, 71, 50, 55};

        int mist = 0; //max if sold today
        int lsf = arr[0]; //least so far
        int[] dpl = new int[arr.length]; //max so far from the left
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= lsf) {
                lsf = arr[i];
            }
            mist = arr[i] - lsf;

            if (mist > dpl[i - 1]) {
                dpl[i] = mist;
            } else {
                dpl[i] = dpl[i - 1];
            }
        }

        int mibt = 0; //max if bought today
        int maxfr = arr[arr.length - 1]; //max from right;
        int[] dpr = new int[arr.length]; //max so far from the right
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= maxfr) {
                maxfr = arr[i];
            }
            mibt = maxfr - arr[i];

            if (mibt >= dpr[i + 1]) {
                dpr[i] = mibt;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dpl[i] + dpr[i] > ans) {
                ans = dpl[i] + dpr[i];
            }
        }
        System.out.println(ans);
    }
}
