package Level1.BinaryTrees;

import java.util.ArrayList;

public class FindAndNodeToRootPath {
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

    public static boolean find(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }
        boolean leftFind = find(root.left, data);
        if (leftFind) {
            return true;
        }
        boolean rightFind = find(root.right, data);
        if (rightFind) {
            return true;
        }

        return false;
    }

    public static ArrayList<Node> nodeToRoot(Node root, int data) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.data == data) {
            ArrayList<Node> res = new ArrayList<>();
            res.add(root);
            return res;
        }
        ArrayList<Node> leftPath = nodeToRoot(root.left, data);
        ArrayList<Node> rightPath = nodeToRoot(root.right, data);
        if (leftPath.size() > 0) {
            leftPath.add(root);
            return leftPath;
        }
        if (rightPath.size() > 0) {
            rightPath.add(root);
            return rightPath;
        }
        return new ArrayList<>();
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

        System.out.println(find(root, 62));
        ArrayList<Node> res = nodeToRoot(root, 30);
        for (Node val : res) {
            System.out.print(val.data + " ");
        }
    }
}
