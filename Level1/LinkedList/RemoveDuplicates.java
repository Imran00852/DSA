package Level1.LinkedList;

public class RemoveDuplicates {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
        }
    }

    public static Node removeDuplicates(Node head){
        if(head==null || head.next==null){
            return head;
        }

        Node curr=head;
        while (curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }else {
                curr=curr.next;
            }

        }
        System.out.println();
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node node=new Node(10);
        node.next=new Node(10);
        node.next.next=new Node(20);
        node.next.next.next=new Node(30);
        node.next.next.next.next=new Node(30);
        node.next.next.next.next.next=new Node(40);


        removeDuplicates(node);
        printList(node);

    }
}
