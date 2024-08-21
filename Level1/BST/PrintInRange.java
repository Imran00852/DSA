package Level1.BST;

public class PrintInRange {
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

    public static void pir(Node root, int d1, int d2) {
        if (root == null) {
            return;
        }
        if (d1 < root.data && d2 < root.data) {
            pir(root.left, d1, d2);
        } else if (d1 > root.data && d2 > root.data) {
            pir(root.right, d1, d2);
        } else {
            pir(root.left, d1, d2);
            System.out.println(root.data);
            pir(root.right, d1, d2);
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
        pir(root, 10, 100);
    }
}
