package Level1.BST;

import java.util.ArrayList;

public class TargetSumPairInBST {
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
        if (data > root.data) {
            return find(root.right, data);
        } else if (data < root.data) {
            return find(root.left, data);
        } else {
            return true;
        }
    }

    //this approach has time complexity of hlogn and space complexity of O(h)
    public static void targetSum1(Node root, Node node, int tar) {
        if (node == null) {
            return;
        }
        targetSum1(root, node.left, tar);
        int compliment = tar - node.data;
        if (node.data < compliment) {
            if (find(root, compliment) == true) {
                System.out.print(node.data + "-" + compliment);
            }
        }
        targetSum1(root, node.right, tar);
    }

    //approach2
    //TC:O(n)    SC:O(n)
    public static void targetSum2(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        targetSum2(root.left, res);
        res.add(root.data);
        targetSum2(root.right, res);

    }

    //best approach
    //Solved in another class

    public static void main(String[] args) {
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.left.left = new Node(12, null, null);
        root.left.right = new Node(10, null, null);

        root.right = new Node(70, null, null);
        root.right.right = new Node(75, null, null);
        root.right.left = new Node(62, null, null);
        root.right.left.left = new Node(60, null, null);
//        targetSum1(root, root, 60);
        int tar = 60;
        ArrayList<Integer> res = new ArrayList<>();
        targetSum2(root, res);

        int li = 0;
        int ri = res.size() - 1;
        while (li < ri) {
            int left = res.get(li);
            int right = res.get(ri);

            if (left + right < tar) {
                li++;
            } else if (left + right > tar) {
                ri--;
            } else {
                System.out.println(left + "-" + right);
                li++;
                ri--;
            }
        }


    }
}
