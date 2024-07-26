package Level1.LinkedList;

public class Main {
    public static class Node {
        int data;
        Node next;

    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        //add last
        void addLast(int data) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = null;

            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        //get linkedlist size
        int size() {
            return size;
        }

        //display
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.print("null");
        }

        //remove first element from ll
        void removeFirst() {
            if (size == 0) {
                System.out.print("Empty Linked List");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        //get first
        int getFirst() {
            if (size == 0) {
                return -1;
            }
            return head.data;
        }

        //get last
        int getLast() {
            if (size == 0) {
                return -1;
            }
            return tail.data;
        }

        //get at index
        int getAt(int idx) {
            if (size == 0) {
                System.out.println("LL is empty");
                return -1;
            } else if (idx < 0) {
                System.out.println("Enter valid idx");
                return -1;
            } else if (idx >= size) {
                return -1;
            }
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        //add first
        void addFirst(int data){
            Node newNode=new Node();
            newNode.data=data;
            newNode.next=head;
            head=newNode;
            if(size==0){
                tail=newNode;
            }
            size++;
        }

        //add at index
        public void addAt(int data, int idx){
            if(idx<0 || idx>size){
                System.out.println("invalid idx");
            } else if (idx==0) {
                addFirst(data);
            } else if (idx==size) {
                addLast(data);
            }else {
                Node newNode=new Node();
                newNode.data=data;
                Node temp=head;
                for(int i=0;i<idx-1;i++){
                    temp=temp.next;
                }
                newNode.next=temp.next;
                temp.next=newNode;
            }

        }

        //remove last
        public void removeLast(){
            if(size==0){
                System.out.println("LL is empty");
            } else if (size==1) {
                tail=head=null;
                size=0;
            }else{
                Node temp=head;
                for(int i=0;i<size-2;i++){
                    temp=temp.next;
                }
                tail=temp;
                temp.next=null;
                size--;
            }

        }

        //remove at index
        void removeAtIdx(int idx){
            if(idx<0 || size ==0 || idx>size){
                System.out.println("Either input is invalid or LL is empty");
            } else if (idx==0) {
                removeFirst();
            } else if (idx==size) {
                removeLast();
            } else{
                Node temp=head;
                for(int i=0;i<idx-1;i++){
                    temp=temp.next;
                }
                temp.next=temp.next.next;
                size--;
            }

        }


        //get node at
        public Node getNodeAt(int idx){
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }
        //reverse using data
        public void reverseDI(){
            int li=0;
            int ri=size-1;

            while(li<=ri){
                Node left=getNodeAt(li);
                Node right=getNodeAt(ri);

                int temp=left.data;
                left.data= right.data;
                right.data=temp;

                li++;
                ri--;
            }
        }

        //reverse using pointers
        public void reversePI(){
            Node prev=null;
            Node curr=head;

            while(curr!=null){
                Node next=curr.next;

                curr.next=prev;
                prev=curr;
                curr=next;
            }

            Node temp=head;
            head=tail;
            tail=temp;
        }

        //kth Element from the end
        public int kthElementFromEnd(int k){
            Node s=head;
            Node f=head;

            for(int i=0;i<k;i++){
                f=f.next;
            }

            while(f!=tail){
                s=s.next;
                f=f.next;
            }

            return s.data;
        }

        //middle of linked list
        public int getMiddleElement(){
            Node s=head;
            Node f=head;

            while(f!=tail && f.next.next!=null){
                f=f.next.next;
                s=s.next;
            }

            return s.data;
        }

        //merge two sorted lists
        public LinkedList mergeSortedLists(LinkedList l1, LinkedList l2){
            LinkedList res=new LinkedList();
            Node one=l1.head;
            Node two=l2.head;

            while(one!=null && two!=null){
                if(one.data<two.data){
                    res.addLast(one.data);
                    one=one.next;
                }else {
                    res.addLast(two.data);
                    two=two.next;
                }
            }

            while(one!=null){
                    res.addLast(one.data);
                    one=one.next;
            }

            while(two!=null){
                    res.addLast(two.data);
                    two=two.next;
            }

            return res;
        }

        //get midddle node
        public Node getMiddleNode(Node head, Node tail){
            Node s=head;
            Node f=head;

            while(f!=tail && f.next!=tail){
                f=f.next.next;
                s=s.next;
            }

            return s;
        }
        //merge sort a linked list
        public LinkedList mergeSortLL(Node head, Node tail){
            if(head==tail){
                LinkedList base=new LinkedList();
                base.addLast(head.data);
                return base;
            }
            Node mid=getMiddleNode(head,tail);
            LinkedList fsh=mergeSortLL(head,mid);
            LinkedList ssh=mergeSortLL(mid.next,tail);
            LinkedList fsl=mergeSortedLists(fsh,ssh);
            return fsl;
        }
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2=new LinkedList();

//        ll1.addFirst(100);
//        ll1.addFirst(90);
//        ll1.addFirst(80);
//        ll1.addFirst(70);
//        ll1.addFirst(60);

        ll2.addFirst(55);
        ll2.addFirst(70);
        ll2.addFirst(310);
        ll2.addFirst(2);
        ll2.addFirst(90);

       LinkedList ll= ll2.mergeSortLL(ll2.head, ll2.tail);
        Node temp=ll.head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp=temp.next;
        }


//        System.out.println("size of linked list"+":"+ " " +ll.size());
//        ll.removeFirst();
//        System.out.println(ll.getAt(2));
//        ll.addFirst(7);
//        ll.removeLast();
//        ll.reverseDI();
//        ll.removeAtIdx(2);
//        ll.reversePI();
        //System.out.println(ll.kthElementFromEnd(1));
//        System.out.println(ll1.getMiddleElement());
//

//        LinkedList res=ll1.mergeSortedLists(ll1,ll2);
//
//        Node temp=res.head;
//        while(temp!=null){
//            System.out.print(temp.data + " ");
//            temp=temp.next;
//        }
    }
}
