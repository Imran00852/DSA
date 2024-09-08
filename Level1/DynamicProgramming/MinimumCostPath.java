package Level1.DynamicProgramming;

public class MinimumCostPath {
    public static void getMinimumCostPath(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                }
            }
        }

        System.out.println(dp[0][0]);
    }

    public static void main(String[] args) {
        int[][] arr = {{6, 2, 1, 0}, {2, 4, 2, 3}, {1, 2, 4, 5}, {6, 1, 6, 5}, {2, 3, 4, 7}, {3, 2, 1, 0}};
        getMinimumCostPath(arr);
    }
}
