package Level1.LinkedList;

public class AddTwoLL {
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

    //reverse
    public static Node reverseLL12(Node head){
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
    public static Node add2LL(Node l1,Node l2){
        if(l1==null || l2==null){
            return l1!=null?l1:l2;
        }
        Node c1=reverseLL12(l1);
        Node c2=reverseLL12(l2);
        Node dummy=new Node(-1);
        Node itr=dummy;

        int carry=0;
        while(c1!=null ||c2!=null ||carry!=0){
            int sum=(c1!=null?c1.data:0)+(c2!=null?c2.data:0)+(carry);

            int digit=sum%10;
            carry=sum/10;

            itr.next=new Node(digit);
            itr=itr.next;

            if(c1!=null) c1=c1.next;
            if(c2!=null) c2=c2.next;
        }

        return reverseLL12(dummy.next);
    }
    public static void main(String[] args) {
        Node node=new Node(7);
        node.next=new Node(2);
        node.next.next=new Node(4);
        node.next.next.next=new Node(3);

        Node node2=new Node(5);
        node2.next=new Node(6);
        node2.next.next=new Node(4);

        Node head=add2LL(node,node2);
        printList(head);
    }
}
