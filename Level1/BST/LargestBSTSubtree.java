package Level1.BST;

public class LargestBSTSubtree {
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
        Node LargestBSTroot;
        int size;
    }

    public static isBST largestBST(Node root) {
        if (root == null) {
            isBST bp = new isBST();
            bp.isBST = true;
            bp.min = Long.MAX_VALUE;
            bp.max = Long.MIN_VALUE;
            bp.LargestBSTroot = null;
            bp.size = 0;
            return bp;
        }
        isBST lp = largestBST(root.left);
        isBST rp = largestBST(root.right);

        isBST rootPair = new isBST();
        rootPair.isBST = lp.isBST && rp.isBST && (root.data > lp.max && root.data < rp.min);
        rootPair.min = Math.min(root.data, Math.min(lp.min, rp.min));
        rootPair.max = Math.max(root.data, Math.max(lp.max, rp.max));

        if (rootPair.isBST) {
            rootPair.LargestBSTroot = root;
            rootPair.size = lp.size + rp.size + 1;
        } else if (lp.size > rp.size) {
            rootPair.LargestBSTroot = lp.LargestBSTroot;
            rootPair.size = lp.size;
        } else {
            rootPair.LargestBSTroot = rp.LargestBSTroot;
            rootPair.size = rp.size;
        }
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

        isBST mp = largestBST(root);
        System.out.println(mp.LargestBSTroot.data + " ");
        System.out.println(mp.size);
    }
}
