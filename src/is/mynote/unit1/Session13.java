package is.mynote.unit1;

import java.util.Comparator;

/**
 * 二分法查找
 *
 * @author neal
 */
public class Session13 {
    /**
     * 递归二分法查找
     *
     * @param x   需要的数组
     * @param key 需要查找的值
     * @param <T> 泛型
     * @return 位置索引
     */
    public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
        return binarySearch(x, 0, x.length - 1, key);
    }


    /**
     * 循环实现二分法查找
     *
     * @param x    数组
     * @param key  需要查找的值
     * @param comp 比较器
     * @param <T>  泛型
     * @return 位置索引
     */
    public static <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
        int low = 0;
        int high = x.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = comp.compare(x[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归实现二分法查找
     *
     * @param x    需要查找的数组
     * @param low  最小
     * @param high 最大
     * @param key  需要查找的值
     * @param <T>  泛型
     * @return 位置
     */
    public static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key.compareTo(x[mid]) == 0) {
                return mid;
            } else if (key.compareTo(x[mid]) < 0) {
                return binarySearch(x, low, mid - 1, key);
            } else {
                return binarySearch(x, mid + 1, high, key);
            }
        }
        return -1;
    }
}
