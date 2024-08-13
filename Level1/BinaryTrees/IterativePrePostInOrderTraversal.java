package Level1.BinaryTrees;

import java.util.Stack;

public class IterativePrePostInOrderTraversal {
    public static class Node {
        int data;
        Node left;
        Node right;

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

    public static void iterativePrePostAndIn(Node root) {
        Stack<Pair> st = new Stack<>();
        Pair rp = new Pair(root, 1);
        st.push(rp);

        String pre = "";
        String in = "";
        String post = "";
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) { //pre,state++,left
                pre += top.node.data + " ";
                top.state++;
                if (top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
            } else if (top.state == 2) {
                in += top.node.data + " ";
                top.state++;
                if (top.node.right != null) {
                    Pair rpp = new Pair(top.node.right, 1);
                    st.push(rpp);
                }
            } else {
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println("Preorder:" + " " + pre);
        System.out.println("Postorder:" + " " + post);
        System.out.println("Inorder:" + " " + in);
    }

    public static void main(String[] args) {
        Node root = new Node(50, null, null);
        //left subtree
        root.left = new Node(25, null, null);
        root.left.left = new Node(12, null, null);
        root.left.right = new Node(37, null, null);
        root.left.right.left = new Node(30, null, null);

        //right subtree
        root.right = new Node(75, null, null);
        root.right.left = new Node(62, null, null);
        root.right.right = new Node(87, null, null);
        root.right.left.right = new Node(70, null, null);

        iterativePrePostAndIn(root);
    }
}
