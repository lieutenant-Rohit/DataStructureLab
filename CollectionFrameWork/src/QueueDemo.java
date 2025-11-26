import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> s = new PriorityQueue<>();
        s.offer(10);
        s.offer(20);
        s.offer(3);
        System.out.print(s);
        s.poll();
        System.out.println(s);
        System.out.println(s.peek());
    }
}
