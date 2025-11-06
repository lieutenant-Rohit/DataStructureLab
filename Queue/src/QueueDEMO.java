import java.util.Scanner;

class Queue {
    int[] arr;
    int front;
    int rear;
    int capacity;
    int size;

    Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is FULL!");
            return;
        }
        arr[++rear] = item;
        size++;
        System.out.println(item + " enqueued successfully!");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY!");
            return;
        }
        int removedItem = arr[front++];
        size--;
        System.out.println("Element dequeued: " + removedItem);
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY!");
            return;
        }
        System.out.println("Element at Front: " + arr[front]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class QueueDEMO {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Capacity of the Queue: ");
        int cap = sc.nextInt();

        Queue q1 = new Queue(cap);

        while (true) {
            System.out.println("\n--- QUEUE MENU ---");
            System.out.println("1 ---> Enqueue");
            System.out.println("2 ---> Dequeue");
            System.out.println("3 ---> Peek");
            System.out.println("4 ---> Display");
            System.out.println("5 ---> EXIT");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter number to Enqueue: ");
                    int no = sc.nextInt();
                    q1.enqueue(no);
                    break;
                case 2:
                    q1.dequeue();
                    break;
                case 3:
                    q1.peek();
                    break;
                case 4:
                    q1.display();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}