package Level1.DynamicProgramming;

public class ClimbingStairsWithVariableJumps {
    public static int climbingStairs(int n, int[] arr) {
        int[] dp = new int[n + 1];

        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] = dp[i] + dp[i + j];
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 0, 2, 2, 3};
        System.out.println(climbingStairs(6, arr));
    }
}

//tabulation steps
//1) Create Storage and assign meaning-->basically each cell represnts how many moves are there to reach 6
//2) Find the dxn to solve the problem
//3) travel and solve
