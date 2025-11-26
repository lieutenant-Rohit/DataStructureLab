import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
//Unordered and No Duplicates
public class SetDemo {
    public static void main(String[] args) {

        Set<Integer> s = new HashSet<>();
        s.add(1);
        System.out.println(s);
        s.add(2);
        s.add(3);
        s.add(1);
        System.out.println(s);
    }
}
