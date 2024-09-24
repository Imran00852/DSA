package Level1.DynamicProgramming;

public class TilingWith2x1Tiles {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
