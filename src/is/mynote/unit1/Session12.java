package is.mynote.unit1;

import java.util.Comparator;

public class Session12 implements Session11 {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = list[j];
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Integer[] intArrys = {2, 5, 3, 6, 2, 34, 2, 53, 5656, 1};
        Session12 session12 = new Session12();
        session12.sort(intArrys);
        for (Integer s : intArrys) {
            System.out.print(s + "\t");
        }
        System.out.println();
        System.out.println(System.currentTimeMillis());
    }
}
