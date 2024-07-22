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
        void AddLast(int data) {
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
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddLast(3);
        ll.AddLast(4);
        ll.AddLast(5);

//        System.out.println("size of linked list"+":"+ " " +ll.size());
//        ll.removeFirst();
        System.out.println(ll.getAt(2));
        ll.display();

    }
}
