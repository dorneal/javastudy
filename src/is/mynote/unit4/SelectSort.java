package is.mynote.unit4;

/**
 * 选择排序
 * 实现思路：
 * 每次循环将最小元素下表得到，交换数据
 * 如果交换的位置不等于原来的位置，则不交换
 *
 * @author neal
 */
public class SelectSort {
    /**
     * 交换数据
     *
     * @param ts  需要交换的数组
     * @param low 下标
     * @param hi  下标
     */
    private void swap(int[] ts, int low, int hi) {
        int temp = ts[low];
        ts[low] = ts[hi];
        ts[hi] = temp;
    }

    public int[] selectSrot(int[] data) {
        int index;
        for (int i = 0; i < data.length; i++) {
            index = i;
            for (int j = i; j < data.length; j++) {
                if (data[index] > data[j]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(data, index, i);
            }
        }
        return data;
    }

    public static void main(String[] args) {

    }
}
