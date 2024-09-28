package Level1.DynamicProgramming;

public class BuyAndSellStocksWithKTransactions {
    public static void main(String[] args) {
        int[] arr = {9, 6, 7, 6, 3, 8};
        int k = 3; //no. of transactions

        int[][] dp = new int[k + 1][arr.length];
        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < arr.length; d++) {
                if (dp[t - 1][d - 1] - arr[d - 1] > max) {
                    max = dp[t - 1][d - 1] - arr[d - 1];
                }
                if (max + arr[d] > dp[t][d - 1]) {
                    dp[t][d] = max + arr[d];
                } else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }
        System.out.println(dp[k][arr.length - 1]);
    }
}


//This approach is O(n3). We can do this in n2 above.
//public class BuyAndSellStocksWithKTransactions {
//    public static void main(String[] args) {
//        int[] arr = {9, 6, 7, 6, 3, 8};
//        int k = 3; //no. of transactions
//
//        int[][] dp = new int[k + 1][arr.length];
//        for (int t = 1; t <= k; t++) {
//            for (int d = 1; d < arr.length; d++) {
//                int max = dp[t][d - 1];
//                for (int pd = 0; pd < d; pd++) {
//                    int pdt = dp[t - 1][pd] + arr[d] - arr[pd]; //past day transaction with difference
//                    if (pdt > max) {
//                        max = pdt;
//                    }
//                }
//                dp[t][d] = max;
//            }
//        }
//        System.out.println(dp[k][arr.length - 1]);
//    }
//}
