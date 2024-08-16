package Level1.BinaryTrees;

public class DiameterOfABinaryTree1 {
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

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int Diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDia = Diameter(root.left);
        int rightDia = Diameter(root.right);
        int rootDia = height(root.left) + height(root.right) + 2;
        int dia = Math.max(rootDia, Math.max(leftDia, rightDia));
        return dia;
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

        System.out.println(Diameter(root));
    }
}

//        O(n^2) approach
//        Diameter of a binary tree is the no. of edges between the two deepest nodes.
//        Algorithm:
//        1) get left diameter
//        2) get right diameter
//        3) get left height and right height and add 1 to it
//        4) The max among the above 3 will be the diameter
