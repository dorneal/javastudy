package is.mynote.unit12;

/**
 * 自顶向下归并排序
 *
 * @author Neal
 */
public class Merge implements ExampleSort {
    /**
     * 辅助数组
     */
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        // 分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 自顶向下的归并排序
     *
     * @param a  数组
     * @param lo 最小索引
     * @param hi 最大索引
     */
    private void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo....hi]排序
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 将左半边排序
        sort(a, lo, mid);
        // 将右半边排序
        sort(a, mid + 1, hi);
        // 归并结果
        merge(a, lo, mid, hi);
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
