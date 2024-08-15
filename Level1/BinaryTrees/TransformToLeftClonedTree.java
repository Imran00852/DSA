package Level1.BinaryTrees;

public class TransformToLeftClonedTree {
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

    public static Node createLeftClonedTree(Node root) {
        if (root == null) {
            return null;
        }
        Node lcr = createLeftClonedTree(root.left);
        Node rcr = createLeftClonedTree(root.right);
        root.left = new Node(root.data, lcr, null);
        root.right = rcr;

        return root;
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

        Node res = createLeftClonedTree(root);
        display(res);

    }
}
