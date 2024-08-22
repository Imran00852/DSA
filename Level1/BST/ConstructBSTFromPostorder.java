package Level1.BST;

public class ConstructBSTFromPostorder {
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

    static int idx = 0;

    public static Node construct(int[] postorder, int lr, int rr) {
        if (idx < 0 || postorder[idx] < lr || postorder[idx] > rr) {
            return null;
        }
        Node root = new Node(postorder[idx--], null, null);
        root.right = construct(postorder, root.data, rr);
        root.left = construct(postorder, lr, root.data);

        return root;
    }

    public static void display(Node root) {
        if (root == null) {
            return;
        }
        display(root.left);
        display(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] postorder = {15, 10, 23, 25, 20, 35, 42, 39, 30};
        idx = postorder.length - 1;
        Node node = construct(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        display(node);
    }
}
