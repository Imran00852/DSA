package Level1.DynamicProgramming;

public class CoinChangeCombination {
    public static void coinChangeCombo(int[] arr, int amt) {
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[amt]);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        coinChangeCombo(arr, 7);
    }
}
