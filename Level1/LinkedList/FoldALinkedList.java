package Level1.LinkedList;

public class FoldALinkedList {
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
    //mid node
    public static Node midNode(Node head){
        Node s=head;
        Node f=head;
        while(f.next!=null && f.next.next!=null){
            f=f.next.next;
            s=s.next;
        }

        return s;
    }
    //reverse
    public static Node getReverseLL(Node head){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
    public static void fold(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node mid=midNode(head);
        Node newHead=mid.next;
        mid.next=null;
        newHead=getReverseLL(newHead);

        Node c1=head;
        Node c2=newHead;
        Node f1=null;
        Node f2=null;

        while(c2!=null){
            f1=c1.next;
            f2=c2.next;

            c1.next=c2;
            c2.next=f1;

            c1=f1;
            c2=f2;
        }
    }
    public static void main(String[] args) {
        Node node=new Node(2);
        node.next=new Node(3);
        node.next.next=new Node(4);
        node.next.next.next=new Node(5);

        fold(node);
        printList(node);
    }
}
