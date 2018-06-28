package is.mynote.unit12;

/**
 * 自底向上归并排序
 *
 * @author Neal
 */
public class MergeBU implements ExampleSort {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

    /**
     * 原地归并
     *
     * @param a   数组
     * @param lo  最小值索引
     * @param mid 中间值索引
     * @param hi  最大值索引
     */
    private void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo...mid]和[mid+1....hi]合并
        int i = lo, j = mid + 1;
        // 复制数组
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // 归并回到a[lo....hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
