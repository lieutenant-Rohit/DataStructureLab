class CLL {

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Insert at beginning
    public void insertFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;  // circular link
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    // Insert at end
    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        node.next = head;
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
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    // Delete first element
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
            tail.next = head;
        }
        size--;
        return val;
    }

    // Delete last element
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        int val = tail.val;
        tail = temp;
        tail.next = head;
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

        Node prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }

        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    // Display list elements
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(Back to Head)");
    }

    public int getSize() {
        return size;
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        CLL list = new CLL();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insert(25, 2);

        System.out.println("Circular Linked List after insertions:");
        list.display();

        System.out.println("\nDeleted first: " + list.deleteFirst());
        list.display();

        System.out.println("\nDeleted last: " + list.deleteLast());
        list.display();

        System.out.println("\nDeleted at index 1: " + list.delete(1));
        list.display();

        System.out.println("\nList size: " + list.getSize());
    }
}