package Level1.LinkedList;

public class OddEvenList {
    static class Node{
        int data;
        Node next;

        public Node(){

        }
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

    public static Node oddEvenList(Node head){
        Node odd=new Node();
        Node even=new Node();

        Node te=even;
        Node to=odd;
        Node temp=head;

        while(temp!=null){
            to.next=temp;
            temp=temp.next;
            to=to.next;



            te.next=temp;
            if(temp==null) break;
            temp=temp.next;
            te=te.next;


        }

        odd=odd.next;
        even=even.next;
        to.next=even;
        return head;
    }

    public static void main(String[] args) {
        Node node=new Node(2);
        node.next=new Node(3);
        node.next.next=new Node(4);
        node.next.next.next=new Node(5);
        node.next.next.next.next=new Node(6);

        oddEvenList(node);
        printList(node);
    }
}
