package Level1.LinkedList;

import static Level1.LinkedList.ReverseKGroup.reverseKNodes;

public class PalindromeLL {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
        }
    }
    public static Node reversePI(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
    public static boolean isPalindromeLL(Node head){
        Node s=head;
        Node f=head;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        Node temp=reversePI(s.next);
        s.next=temp;
        Node p1=head;
        Node p2=s.next;
        while(p2!=null){
            if(p1.data!=p2.data){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }

        return true;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(2);
        node.next.next.next=new Node(1);

        System.out.println(isPalindromeLL(node));
    }
}
