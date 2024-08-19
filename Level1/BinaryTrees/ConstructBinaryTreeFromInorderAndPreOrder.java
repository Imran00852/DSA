package Level1.BinaryTrees;

public class ConstructBinaryTreeFromInorderAndPreOrder {
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

    public static Node buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei) {
            return null;
        }
        int idx = isi;
        while (inorder[idx] != preorder[psi]) {
            idx++;
        }

        int clse = idx - isi;    //count left subtree elements
        Node node = new Node(preorder[psi]);
        node.left = buildTree(preorder, psi + 1, psi + clse, inorder, isi, idx - 1);
        node.right = buildTree(preorder, psi + clse + 1, pei, inorder, idx + 1, iei);

        return node;
    }

    public static void displayPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        displayPreOrder(root.left);
        displayPreOrder(root.right);
    }

    public static void displayInOrder(Node root) {
        if (root == null) {
            return;
        }
        displayInOrder(root.left);
        System.out.print(root.data + " ");
        displayInOrder(root.right);
        ;
    }

    public static void main(String[] args) {
        int[] preorder = {0, 1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 6};
        int[] inorder = {7, 3, 8, 1, 9, 4, 10, 0, 11, 5, 2, 6};

        Node root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        displayPreOrder(root);
        System.out.println();
        displayInOrder(root);
    }
}
