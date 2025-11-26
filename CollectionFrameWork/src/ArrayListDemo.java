import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {

        List<Integer> l = List.of(1,2,3,4); //Immutable
        System.out.println(l);

        List<Integer> l1 = new ArrayList<>(10);
        System.out.println(l1.size());

        List<Integer> l2 = Arrays.asList(1,2,3,4,5,6);

        l1.addAll(l);


        System.out.println(l1);
        l2.set(1,100);
        System.out.println(l2.get(1));
    }
}
