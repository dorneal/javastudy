package is.mynote.unit12;

/**
 * @author Neal
 */
public class Qucik implements ExampleSort {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 数组切分
     *
     * @param a  数组
     * @param lo 左扫描指针
     * @param hi 右扫描指针
     * @return int
     */
    private int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1],a[i],a[i+1...hi]
        int i = lo, j = hi + 1;
        // 切分元素
        Comparable v = a[lo];
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
