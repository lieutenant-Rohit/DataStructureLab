class CDLL {

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    
    public void insertFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            head.next = head;
            head.prev = head;
        } else {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            head = node;
        }
        size++;
    }
    
    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        node.prev = tail;
        node.next = head;
        tail.next = node;
        head.prev = node;
        tail = node;
        size++;
    }
    
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node node = new Node(val);
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
        size++;
    }
    
    public int deleteFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return -1;
        }

        int val = head.val;

        if (head == tail) { // single node
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
        return val;
    }
    
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        int val = tail.val;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
        return val;
    }
    
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        int val = temp.val;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return val;
    }
    
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(Back to Head)");
    }
    
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = tail;
        do {
            System.out.print(temp.val + " <-> ");
            temp = temp.prev;
        } while (temp != tail);

        System.out.println("(Back to Tail)");
    }

    public int getSize() {
        return size;
    }
}

public class CircularDoublyLinkedList {
    public static void main(String[] args) {
        CDLL list = new CDLL();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insert(25, 2);

        System.out.println("Circular Doubly Linked List (Forward):");
        list.displayForward();

        System.out.println("\nCircular Doubly Linked List (Backward):");
        list.displayBackward();

        System.out.println("\nDeleted First Element: " + list.deleteFirst());
        list.displayForward();

        System.out.println("\nDeleted Last Element: " + list.deleteLast());
        list.displayForward();

        System.out.println("\nDeleted Element at Index 1: " + list.delete(1));
        list.displayForward();

        System.out.println("\nCurrent size of list: " + list.getSize());
    }
}