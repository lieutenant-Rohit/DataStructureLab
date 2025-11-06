import java.util.Scanner;

class CircularQueue {
    int[] arr;
    int front;
    int rear;
    int capacity;
    int size;

    CircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is FULL! Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
        System.out.println(item + " enqueued successfully!");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY! Cannot dequeue.");
            return;
        }
        int removedItem = arr[front];
        front = (front + 1) % capacity;
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
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Capacity of Circular Queue: ");
        int cap = sc.nextInt();

        CircularQueue q = new CircularQueue(cap);

        while (true) {
            System.out.println("\n--- CIRCULAR QUEUE MENU ---");
            System.out.println("1 ---> Enqueue");
            System.out.println("2 ---> Dequeue");
            System.out.println("3 ---> Peek");
            System.out.println("4 ---> Display");
            System.out.println("5 ---> Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter number to enqueue: ");
                    int num = sc.nextInt();
                    q.enqueue(num);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}