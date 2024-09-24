package Level1.DynamicProgramming;

public class PaintHouseWithManyColors {
    public static void main(String[] args) {
        int[][] arr = {{1, 5, 4, 2}, {3, 4, 2, 5}, {3, 1, 5, 4}, {6, 7, 8, 1}};

        int[][] dp = new int[arr.length][arr[0].length];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = arr[0][j];
            if (arr[0][j] <= least) {
                sleast = least;
                least = arr[0][j];
            } else if (arr[0][j] <= sleast) {
                sleast = arr[0][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < dp[0].length; j++) {
                if (least == dp[i - 1][j]) {
                    dp[i][j] = arr[i][j] + sleast;
                } else {
                    dp[i][j] = arr[i][j] + least;
                }
                if (arr[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (arr[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }
        System.out.println(least);
    }
}
