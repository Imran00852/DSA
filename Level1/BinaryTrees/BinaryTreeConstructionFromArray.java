package Level1.BinaryTrees;


import java.util.Stack;

public class BinaryTreeConstructionFromArray {
    public static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node root) {
        if (root == null) {
            return;
        }
        display(root.left);
        System.out.print(root.data + " ");
        display(root.right);
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int totalSum = leftSum + rightSum + root.data;
        return totalSum;
    }

    public static int max(Node root) {
        if (root == null) {
            return 0;
        }
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        int maxOfLeftAndRight = Math.max(leftMax, rightMax);
        int max = Math.max(maxOfLeftAndRight, root.data);

        return max;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null,
                null, null, 75, 62, null, 70, null, null, 87, null, null};

        Node root = new Node(arr[0], null, null);
        Pair pair = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(pair);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }

//        display(root);
//        System.out.println(size(root));
//        System.out.println(sum(root));
//        System.out.println(max(root));
        System.out.println(height(root));
    }
}
