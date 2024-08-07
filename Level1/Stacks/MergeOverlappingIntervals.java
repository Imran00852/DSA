package Level1.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public static class Pair implements Comparable<Pair> {
        int startTime;
        int endTime;

        public Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        //this>o--> return +ve
        //this==o--> return 0
        //this<o-->return -ve
        public int compareTo(Pair o) {
            if (this.startTime != o.startTime) {
                return this.startTime - o.startTime; //jiska startime kam woh pehle rakha jayega array mai
            } else {
                return this.endTime - o.endTime;
            }
        }
    }

    public static void mergeOverlappingIntervals(int arr[][]) {
        Pair pairs[] = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);
        for (int i = 1; i < pairs.length; i++) {
            Pair top = st.peek();
            if (top.endTime < pairs[i].startTime) {
                st.push(pairs[i]);
            } else {
                top.endTime = Math.max(top.endTime, pairs[i].endTime);
            }

        }

        Stack<Pair> res = new Stack<>();
        while (st.size() > 0) {
            res.push(st.pop());
        }

        while (res.size() > 0) {
            Pair peek = res.pop();
            System.out.println(peek.startTime + " " + peek.endTime);
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{22, 28},
                {1, 8}, {25, 27}, {14, 19}, {27, 30}, {5, 12}};

        mergeOverlappingIntervals(arr);
    }
}
