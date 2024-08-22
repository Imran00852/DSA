package Level1.BST;

public class ConstructBSTFromPreorder {
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

    public static Node construct(int[] preorder, int lr, int rr) {
        if (idx >= preorder.length || preorder[idx] < lr || preorder[idx] > rr) {
            return null;
        }
        Node root = new Node(preorder[idx++], null, null);
        root.left = construct(preorder, lr, root.data);
        root.right = construct(preorder, root.data, rr);

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
        int[] preorder = {30, 20, 10, 15, 25, 23, 39, 35, 42};
        Node node = construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        display(node);
    }
}
