package Level1.LinkedList;

public class ReverseKGroup {
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
    public static Node getKthNode(Node head,int k){
        if(head==null){
            return null;
        }
        Node temp=head;
        for(int i=1;i<k && temp!=null;i++){
            temp=temp.next;
        }

        return temp;
    }
    public static Node reverseKNodes(Node head){
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
    public static Node reverseKGroup(Node head,int k){
        if(head==null){
            return null;
        }
        Node temp=head;
        Node prev=null;
        Node nextNode=null;
        Node kthNode=null;
        while(temp!=null){
            kthNode=getKthNode(temp,k);
            if(kthNode==null){
                if(prev!=null){
                    prev.next=temp;
                }
                break;
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            reverseKNodes(temp);
            if(temp==head){
                head=kthNode;
            }else{
                prev.next=kthNode;
            }

            prev=temp;
            temp=nextNode;
        }

        return head;
    }
    public static void main(String[] args) {
        Node node=new Node(2);
        node.next=new Node(3);
        node.next.next=new Node(4);
        node.next.next.next=new Node(5);
        node.next.next.next.next=new Node(6);
        node.next.next.next.next.next=new Node(7);
        node.next.next.next.next.next.next=new Node(8);
        node.next.next.next.next.next.next.next=new Node(9);
        node.next.next.next.next.next.next.next.next=new Node(10);

        Node head=reverseKGroup(node,3);
        printList(head);
    }
}
