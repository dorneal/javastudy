package is.mynote.unit12;

/**
 * 顶级排序接口
 *
 * @author Neal
 */
public interface ExampleSort {
    /**
     * 排序
     *
     * @param a 数组
     */
    void sort(Comparable[] a);

    /**
     * 判断V 是否小于 W
     *
     * @param v 数值v
     * @param w 数值w
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    default boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 数据交换
     *
     * @param a 数组a
     * @param i 数值i
     * @param j 数值j
     */
    default void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印数组
     *
     * @param a 数组a
     */
    default void show(Comparable[] a) {
        StringBuilder string = new StringBuilder(a.getClass()
                .getName()).append(" [ ");
        for (Comparable s : a) {
            string.append(s).append(" ");
        }
        string.append("]").append("\n");
        System.out.println(string.toString());
    }

    /**
     * 判断是否有序
     *
     * @param a 数组a
     * @return boolean
     */
    default boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
