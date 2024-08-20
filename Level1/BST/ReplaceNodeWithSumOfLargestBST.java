package Level1.BST;

public class ReplaceNodeWithSumOfLargestBST {
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

    static int sum = 0;

    public static void rwln(Node root) {
        if (root == null) {
            return;
        }
        //reverse in order
        rwln(root.right);
        int od = root.data;
        root.data = sum;
        sum += od;
        rwln(root.left);
    }

    public static void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
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

        rwln(root);
        display(root);
    }
}
