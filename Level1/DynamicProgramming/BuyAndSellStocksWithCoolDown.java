package Level1.DynamicProgramming;

public class BuyAndSellStocksWithCoolDown {
    public static void main(String[] args) {
        int[] arr = {10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};

        int obsp = -arr[0]; //old bought state profit
        int ossp = 0;
        int ocsp = 0; //old cooldown state profit

        for (int i = 1; i < arr.length; i++) {
            int nbsp, nssp, ncsp;

            if (ocsp - arr[i] >= obsp) {
                nbsp = ocsp - arr[i];
            } else {
                nbsp = obsp;
            }

            if (obsp + arr[i] >= ossp) {
                nssp = obsp + arr[i];
            } else {
                nssp = ossp;
            }

            if (ossp > ocsp) {
                ncsp = ossp;
            } else {
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        System.out.println(ossp);
    }
}
