package Level1.DynamicProgramming;

public class CountBinaryStrings {
    public static void main(String[] args) {
        int n = 6;

        int oldZerosCount = 1;
        int oldOnesCount = 1;

        for (int i = 2; i <= n; i++) {
            int newZerosCount = oldOnesCount;
            int newOnesCount = oldZerosCount + oldOnesCount;


            oldOnesCount = newOnesCount;
            oldZerosCount = newZerosCount;
        }

        System.out.println(oldZerosCount + oldOnesCount);
    }
}
