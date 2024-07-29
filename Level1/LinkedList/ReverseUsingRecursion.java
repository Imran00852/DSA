package Level1.LinkedList;

public class ReverseUsingRecursion {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
        }
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.println();
    }
    public static void reverseRecursive(Node head){
        if(head==null){
            return;
        }
        reverseRecursive(head.next);
        System.out.print(head.data + " ");
    }
    public static void main(String[] args) {
        Node node=new Node(2);
        node.next=new Node(3);
        node.next.next=new Node(4);
        node.next.next.next=new Node(5);
        node.next.next.next.next=new Node(6);

        reverseRecursive(node);
    }
}
