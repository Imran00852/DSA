package Level1.BinaryTrees;

import java.util.ArrayList;


public class PrintKLevelsFar {
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

    public static void printKLevelsDown(Node root, int k, Node blocker) {
        if (root == null || k < 0 || root == blocker) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
        }
        printKLevelsDown(root.left, k - 1, blocker);
        printKLevelsDown(root.right, k - 1, blocker);
    }

    public static void printKLevelsFar(Node root, int data, int k) {
        ArrayList<Node> path = nodeToRoot(root, data);
        for (int i = 0; i < path.size(); i++) {
            printKLevelsDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
        }
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

        printKLevelsFar(root, 25, 3);
    }
}
