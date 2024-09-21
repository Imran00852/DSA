package Level1.DynamicProgramming;

public class CoinChangePermutations {
    public static void coinChangePermutation(int[] coins, int tar) {
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int amt = 1; amt <= tar; amt++) {
            for (int coin : coins) {
                if (coin <= amt) {
                    int ramt = amt - coin;
                    dp[amt] += dp[ramt];
                }

            }
        }

        System.out.println(dp[tar]);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        coinChangePermutation(arr, 7);
    }
}
