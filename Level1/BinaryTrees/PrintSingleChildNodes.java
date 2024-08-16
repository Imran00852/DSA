package Level1.BinaryTrees;

public class PrintSingleChildNodes {
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

    public static void printNodesWith1Child(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right == null) {
            System.out.println(root.left.data);
        }
        if (root.right != null && root.left == null) {
            System.out.println(root.right.data);
        }
        printNodesWith1Child(root.left);
        printNodesWith1Child(root.right);
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
        printNodesWith1Child(root);
    }
}
