package is.mynote.unit4;

import java.util.Random;

/**
 * 随机产生10个1-100之间的整数并放在一个数组中
 * 排序：将数组中值最大的数放在第一位，最小的放在第二位，
 * 剩下的最大的放在第三位，小的放在第四位，以此类推
 *
 * @author neal
 */
public class SortByRandom {
    public static void main(String[] args) {
        int[] myNubs = new int[10];

        // 构建数组
        for (int i = 0; i < myNubs.length; i++) {
            myNubs[i] = new Random().nextInt(101);
        }
        // 排序
        for (int i = 1; i < myNubs.length; i++) {
            for (int j = i; j > 0 && myNubs[j] > myNubs[j - 1]; j--) {
                int temp = myNubs[j];
                myNubs[j] = myNubs[j - 1];
                myNubs[j - 1] = temp;
            }
        }

        //输出
        for (int s : myNubs) {
            System.out.print(s + "\t");
        }
    }
}
