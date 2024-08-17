package Level1.BinaryTrees;

public class TiltOfABinaryTree {
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

    //travel and change strategy
    static int tilt = 0;

    public static int tilt(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = tilt(root.left);
        int rightSum = tilt(root.right);

        int rootilt = Math.abs(leftSum - rightSum);
        tilt += rootilt;

        int ts = leftSum + rightSum + root.data;
        return ts;
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

        tilt(root);
        System.out.println(tilt);
    }
}
