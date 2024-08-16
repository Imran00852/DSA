package Level1.BinaryTrees;

public class TransformBackFromLeftClonedTree {
    public static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node transformBack(Node root) {
        if (root == null || root.left == null) {
            return null;
        }

        Node lt = transformBack(root.left.left);
        Node rt = transformBack(root.right);

        root.left = lt;
        root.right = rt;

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
        Node root = new Node("a", null, null);
        root.left = new Node("a", null, null);
        root.left.left = new Node("b", null, null);
        root.left.left.left = new Node("b", null, null);

        root.right = new Node("c", null, null);
        root.right.left = new Node("c", null, null);
        root.right.left.left = new Node("d", null, null);
        root.right.left.left.left = new Node("d", null, null);

        Node res = transformBack(root);
        display(res);
    }
}
