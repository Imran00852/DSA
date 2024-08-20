package Level1.BST;

public class ConstructBST {
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

    public static Node constructBST(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        int data = arr[mid];
        Node leftSubtree = constructBST(arr, lo, mid - 1);
        Node rightSubtree = constructBST(arr, mid + 1, hi);

        Node root = new Node(data, leftSubtree, rightSubtree);

        return root;
    }

    //size
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = size(root.left);
        int rs = size(root.right);

        return ls + rs + 1;
    }

    //sum
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int lsum = sum(root.left);
        int rsum = sum(root.right);
        return lsum + rsum + root.data;
    }

    //min
    public static int min(Node root) {
        if (root.left != null) {
            return min(root.left);
        } else {
            return root.data;
        }
    }

    //max
    public static int max(Node root) {
        if (root.right != null) {
            return max(root.right);
        } else {
            return root.data;
        }
    }

    //find
    public static boolean find(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (data > root.data) {
            return find(root.right, data);
        } else if (data < root.data) {
            return find(root.left, data);
        } else {
            return true;
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

    public static void main(String[] args) {
        int[] arr = {20, 30, 40, 50, 60, 70, 80};
        Node root = constructBST(arr, 0, arr.length - 1);
//        display(root);
        System.out.println(size(root));
        System.out.println(min(root));
        System.out.println(max(root));
        System.out.println(sum(root));
        System.out.println(find(root, 70));
    }
}
