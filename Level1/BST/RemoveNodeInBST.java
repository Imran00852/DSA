package Level1.BST;

public class RemoveNodeInBST {
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

    public static int max(Node root) {
        if (root.right != null) {
            return max(root.right);
        } else {
            return root.data;
        }
    }

    public static Node removeNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            node.right = removeNode(node.right, data);
        } else if (data < node.data) {
            node.left = removeNode(node.left, data);
        } else {
            if (node.left != null && node.right != null) {
                int leftMax = max(node.left);
                node.data = leftMax;
                node.left = removeNode(node.left, leftMax);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }

        return node;
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

        Node node = removeNode(root, 25);
        display(node);
    }
}
