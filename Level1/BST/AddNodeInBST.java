package Level1.BST;

public class AddNodeInBST {
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

    public static void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }

    public static Node addNode(Node node, int data) {
        if (node == null) {
            return new Node(data, null, null);
        }
        if (data > node.data) {
            node.right = addNode(node.right, data);
        } else if (data < node.data) {
            node.left = addNode(node.left, data);
        } else {
            //nothing to do...>if data is already present
        }

        return node;
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

        Node node = addNode(root, 20);
        display(node);
    }
}
