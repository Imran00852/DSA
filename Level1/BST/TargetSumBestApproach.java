package Level1.BST;

import java.util.Stack;

public class TargetSumBestApproach {
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

    public static Node getNextFromNormalInorder(Stack<Pair> ls) {
        while (ls.size() > 0) {
            Pair top = ls.peek();
            if (top.state == 1) {
                if (top.node.left != null) {
                    ls.push(new Pair(top.node.left, 1));
                }
                top.state++;
            } else if (top.state == 2) {
                if (top.node.right != null) {
                    ls.push(new Pair(top.node.right, 1));
                }
                top.state++;
                return top.node;
            } else {
                ls.pop();
            }
        }
        return null;
    }

    public static Node getNextFromReverseInorder(Stack<Pair> rs) {
        while (rs.size() > 0) {
            Pair top = rs.peek();
            if (top.state == 1) {
                if (top.node.right != null) {
                    rs.push(new Pair(top.node.right, 1));
                }
                top.state++;
            } else if (top.state == 2) {
                if (top.node.left != null) {
                    rs.push(new Pair(top.node.left, 1));
                }
                top.state++;
                return top.node;
            } else {
                rs.pop();
            }
        }
        return null;
    }

    public static void targetSumPair(Node root, int tar) {
        Stack<Pair> ls = new Stack<>();
        Stack<Pair> rs = new Stack<>();
        ls.push(new Pair(root, 1));
        rs.push(new Pair(root, 1));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);
        while (left.data < right.data) {
            if (left.data + right.data < tar) {
                left = getNextFromNormalInorder(ls);
            } else if (left.data + right.data > tar) {
                right = getNextFromNormalInorder(rs);
            } else {
                System.out.print(left.data + "-" + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromNormalInorder(rs);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.left.left = new Node(12, null, null);
        root.left.right = new Node(10, null, null);

        root.right = new Node(70, null, null);
        root.right.right = new Node(75, null, null);
        root.right.left = new Node(62, null, null);
        root.right.left.left = new Node(60, null, null);

        targetSumPair(root, 100);
    }
}
