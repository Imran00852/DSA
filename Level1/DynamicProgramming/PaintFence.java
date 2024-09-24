package Level1.DynamicProgramming;

public class PaintFence {
    public static void main(String[] args) {
        int n = 3, k = 3; //n=fences k=colors

        int same = k * 1;
        int diff = k * (k - 1);
        int total = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }

        System.out.println(total);
    }
}
