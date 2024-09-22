package Level1.DynamicProgramming;

public class UnboundedKnapsack {
    public static void unboundedKnapsack(int[] wts, int[] vals, int cap) {
        int[] dp = new int[cap + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < wts.length; j++) {
                if (wts[j] <= i) {
                    int rCap = i - wts[j];
                    int rVal = dp[rCap];
                    int tCap = rVal + vals[j];

                    if (tCap > max) {
                        max = tCap;
                    }
                }
            }
            dp[i] = max;
        }

        System.out.println(dp[cap]);
    }

    public static void main(String[] args) {
        int[] wts = {2, 5, 1, 3, 4};
        int[] vals = {15, 14, 10, 45, 30};
        int cap = 7;

        unboundedKnapsack(wts, vals, cap);
    }
}
