package Level1.DynamicProgramming;

public class BuyAndSellStocksWithInfiniteTransactions {
    public static void main(String[] args) {
        int[] prices = {2, 5, 3, 1, 6, 7, 2, 8};

        int bd = 0; //buying day
        int sd = 0; //selling day
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sd++;
            } else {
                profit += prices[sd] - prices[bd];
                sd = bd = i;
            }
        }
        profit += prices[sd] - prices[bd];
        System.out.println(profit);
    }
}
