package is.mynote.unit12;

/**
 * 希尔排序
 *
 * @author Neal
 */
public class Shell implements ExampleSort {
    @Override
    public void sort(Comparable[] a) {
        // 将a[] 按升序排序
        int n = a.length;
        // 1,4,13,40,121,364,1093,......
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 将数组变成为h有序
            for (int i = h; i < n; i++) {
                // 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
