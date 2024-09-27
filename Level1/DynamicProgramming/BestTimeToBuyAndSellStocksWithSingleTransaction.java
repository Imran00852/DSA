package Level1.DynamicProgramming;

public class BestTimeToBuyAndSellStocksWithSingleTransaction {
    public static void main(String[] args) {
        int[] prices = {2, 5, 3, 1, 6, 7, 2, 8};

        int maxProfit = 0;
        int lsp = Integer.MAX_VALUE; //least selling point(you would rather buy(stock) here)


        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsp) {
                lsp = prices[i];
            }
            int presentProfit = prices[i] - lsp;

            if (presentProfit > maxProfit) {
                maxProfit = presentProfit;
            }
        }

        System.out.println(maxProfit);
    }
}
