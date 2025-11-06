class DLL {

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Insert at beginning
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    // Insert at end
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    // Insert at a specific index
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

    // Delete first node
    public int deleteFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return -1;
        }
        int val = head.val;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return val;
    }

    // Delete last node
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        int val = tail.val;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    // Delete at specific index
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

    // Display from head to tail
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Display from tail to head
    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    public int getSize() {
        return size;
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DLL list = new DLL();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(30);
        list.insert(25, 2);

        System.out.println("Doubly Linked List (Forward):");
        list.displayForward();

        System.out.println("\nDoubly Linked List (Backward):");
        list.displayBackward();

        System.out.println("\nDeleted First Element: " + list.deleteFirst());
        list.displayForward();

        System.out.println("\nDeleted Last Element: " + list.deleteLast());
        list.displayForward();

        list.insertLast(40);
        list.insertLast(50);
        list.insertLast(60);
        System.out.println("\nAfter inserting more elements:");
        list.displayForward();

        System.out.println("\nDeleted Element at Index 2: " + list.delete(2));
        list.displayForward();

        System.out.println("\nList size: " + list.getSize());
    }
}