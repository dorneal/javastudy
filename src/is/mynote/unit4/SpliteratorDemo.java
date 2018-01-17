package is.mynote.unit4;

import java.util.*;

public class SpliteratorDemo {
    public static void main(String[] args) {
        ArrayList<Double> vals = new ArrayList<>(16);
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        System.out.println("Content of vals:\n");
        Spliterator<Double> spliterator = vals.spliterator();
        while (spliterator.tryAdvance(System.out::println)) {

        }
        System.out.println();
        spliterator = vals.spliterator();
        ArrayList<Double> ars = new ArrayList<>();
        while (spliterator.tryAdvance((n) -> ars.add(Math.sqrt(n)))) {
        }
        System.out.print("Contents of sqrs :\n");
        spliterator = ars.spliterator();
        spliterator.forEachRemaining(System.out::println);
        System.out.println();
        Set<String> stringSet = new LinkedHashSet<>();
        for (String aStringSet : stringSet) {
            System.out.println(aStringSet);
        }
        Object o = 3;
        Object o1 = new Object();
        Object o2 = new Object[3];
        Object o3 = new Integer(4);
    }
}
