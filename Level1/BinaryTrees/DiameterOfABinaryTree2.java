package Level1.BinaryTrees;

public class DiameterOfABinaryTree2 {
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

    public static class DiaPair {
        int ht;
        int dia;
    }

    public static DiaPair diameter(Node root) {
        if (root == null) {
            DiaPair bp = new DiaPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }
        DiaPair lp = diameter(root.left);
        DiaPair rp = diameter(root.right);

        DiaPair myPair = new DiaPair();  //root
        myPair.ht = Math.max(lp.ht, rp.ht) + 1;
        int rootDia = lp.ht + rp.ht + 2;
        myPair.dia = Math.max(rootDia, Math.max(lp.dia, rp.dia));

        return myPair;
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

        DiaPair mp = diameter(root);
        System.out.println(mp.dia);
    }

    //0(n) approach
}
