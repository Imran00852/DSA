package Level1.BinaryTrees;

public class BalancedBinaryTree {
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
        boolean isBalanced;
        int ht;
    }

    public static Pair isBalanced(Node root) {
        if (root == null) {
            Pair bp = new Pair();
            bp.isBalanced = true;
            bp.ht = 0;
            return bp;
        }
        Pair lp = isBalanced(root.left);
        Pair rp = isBalanced(root.right);

        Pair rootPair = new Pair();
        rootPair.isBalanced = Math.abs(lp.ht - rp.ht) <= 1 && (lp.isBalanced && rp.isBalanced);
        rootPair.ht = Math.max(lp.ht, rp.ht) + 1;

        return rootPair;
    }

    public static void main(String[] args) {
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.left.left = new Node(12, null, null);
        root.left.right = new Node(37, null, null);

        root.right = new Node(75, null, null);
        root.right.right = new Node(87, null, null);
        root.right.left = new Node(62, null, null);
        Pair mp = isBalanced(root);
        System.out.println(mp.isBalanced);
    }
}

//for a binary tree to be balanced, |Height of leftNode-Height of rightNode|<=1
