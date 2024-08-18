package Level1.BST;

public class ValidateBST {
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

    public static class isBST {
        boolean isBST;
        long min;
        long max;
    }

    public static isBST validateBST(Node root) {
        if (root == null) {
            isBST bp = new isBST();
            bp.isBST = true;
            bp.min = Long.MAX_VALUE;
            bp.max = Long.MIN_VALUE;

            return bp;
        }
        isBST lp = validateBST(root.left);
        isBST rp = validateBST(root.right);

        isBST rootPair = new isBST();
        rootPair.isBST = lp.isBST && rp.isBST && (root.data > lp.max && root.data < rp.min);
        rootPair.min = Math.min(root.data, Math.min(lp.min, rp.min));
        rootPair.max = Math.max(root.data, Math.max(lp.max, rp.max));

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

        isBST mp = validateBST(root);
        System.out.println(mp.isBST);
    }
}
