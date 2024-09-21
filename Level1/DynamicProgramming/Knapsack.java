package Level1.DynamicProgramming;

//0-1 knapsack
public class Knapsack {
    public static void knapsack(int[] wts, int[] vals, int cap) {
        int[][] dp = new int[wts.length + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= wts[i - 1]) {
                    if (dp[i - 1][j - wts[i - 1]] + vals[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j - wts[i - 1]] + vals[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[wts.length][cap]);
    }

    public static void main(String[] args) {
        int[] wts = {2, 5, 1, 3, 4};
        int[] vals = {15, 14, 10, 45, 30};
        int cap = 7;

        knapsack(wts, vals, cap);
    }
}
