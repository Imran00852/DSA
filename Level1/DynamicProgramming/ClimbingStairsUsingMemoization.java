package Level1.DynamicProgramming;

public class ClimbingStairsUsingMemoization {
    public static int getCountOfClimbingStairs(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int nm1 = getCountOfClimbingStairs(n - 1, qb);
        int nm2 = getCountOfClimbingStairs(n - 2, qb);
        int nm3 = getCountOfClimbingStairs(n - 3, qb);

        int totalpaths = nm1 + nm2 + nm3;
        qb[n] = totalpaths;
        return totalpaths;
    }

    public static void main(String[] args) {
        System.out.println(getCountOfClimbingStairs(10, new int[11]));
    }
}
