package is.mynote.unit1;

import java.util.Comparator;

/**
 * 排序器接口（策略模式：将算法封装到具体共同接口的独立的类中使得他们可以相互替换）
 */
public interface Session11 {
    /**
     * 排序
     *
     * @param list 排序数组
     * @param <T>  泛型
     */
    <T extends Comparable<T>> void sort(T[] list);

    /**
     * 特定排序
     *
     * @param list 待排序的数组
     * @param comp 比较器
     * @param <T>  泛型
     */
    <T> void sort(T[] list, Comparator<T> comp);
}
