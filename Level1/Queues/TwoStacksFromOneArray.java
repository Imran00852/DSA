package Level1.Queues;

public class TwoStacksFromOneArray {
    public static void main(String[] args) {
        TwoStacks st = new TwoStacks(5);
        st.push1(10);
        st.push2(20);
        st.push1(30);

        while (st.size1() > 0) {
            System.out.print(st.pop1() + " ");
        }
    }

    public static class TwoStacks {
        int[] data;
        int tos1;
        int tos2;

        public TwoStacks(int cap) {
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return data.length - tos2;
        }

        void push1(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            }
            tos1++;
            data[tos1] = val;
        }

        void push2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            }
            tos2--;
            data[tos2] = val;
        }

        int pop1() {
            if (size1() == 0) {
                System.out.println("Empty Stack");
                return -1;
            }
            int val = data[tos1];
            tos1--;

            return val;
        }

        int pop2() {
            if (size2() == 0) {
                System.out.println("Empty Stack");
                return -1;
            }
            int val = data[tos2];
            tos2++;

            return val;
        }

        int top1() {
            if (size1() == 0) {
                System.out.println("Empty Stack");
                return -1;
            }

            return data[tos1];
        }

        int top2() {
            if (size2() == 0) {
                System.out.println("Empty Stack");
                return -1;
            }

            return data[tos2];
        }
    }
}
