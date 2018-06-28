package is.mynote.unit12;

/**
 * 插入排序
 *
 * @author Neal
 */
public class Insertion implements ExampleSort {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
