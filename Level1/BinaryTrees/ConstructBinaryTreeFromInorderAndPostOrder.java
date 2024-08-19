package Level1.BinaryTrees;

public class ConstructBinaryTreeFromInorderAndPostOrder {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei) {
            return null;
        }
        int idx = isi;
        while (inorder[idx] != postorder[pei]) {
            idx++;
        }
        int clse = idx - isi;
        Node node = new Node(postorder[pei]);
        node.left = buildTree(postorder, psi, psi + clse - 1, inorder, isi, idx - 1);
        node.right = buildTree(postorder, psi + clse, pei - 1, inorder, idx + 1, iei);

        return node;
    }

    public static void displayPostOrder(Node root) {
        if (root == null) {
            return;
        }
        displayPostOrder(root.left);
        displayPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void displayInOrder(Node root) {
        if (root == null) {
            return;
        }
        displayInOrder(root.left);
        System.out.print(root.data + " ");
        displayInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] postorder = {7, 8, 3, 9, 10, 4, 1, 11, 5, 6, 2, 0};
        int[] inorder = {7, 3, 8, 1, 9, 4, 10, 0, 11, 5, 2, 6};

        Node root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
        displayPostOrder(root);
        System.out.println();
        displayInOrder(root);
    }
}
