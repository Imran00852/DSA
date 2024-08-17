package Level1.BinaryTrees;

public class TiltOfBinaryTreeUsingPairClass {
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

    public static class TiltPair {
        int sum;
        int tilt;
    }

    public static TiltPair tilt2(Node root) {
        if (root == null) {
            TiltPair bp = new TiltPair();
            bp.tilt = 0;
            bp.sum = 0;
            return bp;
        }
        TiltPair lp = tilt2(root.left);
        TiltPair rp = tilt2(root.right);

        TiltPair rootPair = new TiltPair();
        rootPair.sum = lp.sum + rp.sum + root.data;
        rootPair.tilt = Math.abs(lp.sum - rp.sum) + lp.tilt + rp.tilt;

        return rootPair;
    }

    public static void main(String[] args) {
        Node root = new Node(50, null, null);
        //left subtree
        root.left = new Node(25, null, null);
        root.left.left = new Node(12, null, null);
        root.left.left.left = new Node(18, null, null);
        root.left.left.right = new Node(19, null, null);
        root.left.right = new Node(37, null, null);
        root.left.right.left = new Node(50, null, null);

        //right subtree
        root.right = new Node(75, null, null);
        root.right.left = new Node(62, null, null);
        root.right.right = new Node(87, null, null);
        root.right.left.right = new Node(70, null, null);


        TiltPair mp = tilt2(root);
        System.out.println(mp.tilt);
    }
}
