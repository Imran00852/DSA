package Level1.DynamicProgramming;

public class BuyAndSellStocksWithFeeAndInfinteTransactions {
    public static void main(String[] args) {
        int[] arr = {10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};
        int fee = 3;

        int bsp = -arr[0]; //bought state profit
        int ssp = 0; //sold state profit

        for (int i = 1; i < arr.length; i++) {
            int nbsp;
            int nssp;

            if (ssp - arr[i] >= bsp) {
                nbsp = ssp - arr[i];
            } else {
                nbsp = bsp;
            }

            if (bsp + arr[i] - fee > ssp) {
                nssp = bsp + arr[i] - fee;
            } else {
                nssp = ssp;
            }

            bsp = nbsp;
            ssp = nssp;
        }
        System.out.println(ssp);
    }
}
