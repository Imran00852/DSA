package Level1.BinaryTrees;

public class PrintKLevelsDown {
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

    public static void printKLevelsDown(Node root, int k) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
        }
        printKLevelsDown(root.left, k - 1);
        printKLevelsDown(root.right, k - 1);

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
        printKLevelsDown(root, 1);
    }
}
