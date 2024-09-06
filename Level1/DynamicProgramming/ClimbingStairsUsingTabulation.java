package Level1.DynamicProgramming;

public class ClimbingStairsUsingTabulation {
    public static int getClimbingStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; //to reach zero from zero i have 1 path

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(getClimbingStairs(6));
    }
}
