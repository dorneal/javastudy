package is.mynote.unit12;


/**
 * 选择排序，将第一个数组元素，与所有元素进行比对，将最小的放到第一位[0]。
 *
 * @author Neal
 */
public class Selection implements ExampleSort {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            /* 将a[i]与a[i+1....n]中最小的元素交换 */
            // 最小元素索引
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
