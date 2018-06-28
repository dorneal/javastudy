package is.mynote.unit12;

import java.util.Random;

/**
 * 排序比较
 *
 * @author Neal
 */
public class SortCompare {
    /**
     * 排序，并统计所耗费时间
     *
     * @param alg 所选排序方法
     * @param a   需排序数组
     * @return double
     */
    private static double time(String alg, Double[] a) {
        long startTime = System.currentTimeMillis();
        if ("Insertion".equalsIgnoreCase(alg)) {
            Insertion insertion = new Insertion();
            insertion.sort(a);
            // insertion.show(a);
        }
        if ("Selection".equalsIgnoreCase(alg)) {
            Selection selection = new Selection();
            selection.sort(a);
            // selection.show(a);
        }
        return System.currentTimeMillis() - startTime;
    }

    /**
     * 生成t个长度为n的数组，并排序统计时间
     *
     * @param alg 所选排序方法
     * @param n   数组长度
     * @param t   数组个数
     * @return double
     */
    private static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] a = new Double[n];
        Random random = new Random();
        for (int s = 0; s < t; s++) {
            for (int i = 0; i < n; i++) {
                a[i] = random.nextDouble();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Selection";
        String alg2 = "Insertion";
        int n = 1000;
        int t = 100;

        double spendTime1 = timeRandomInput(alg1, n, t);
        double spendTime2 = timeRandomInput(alg2, n, t);
        System.out.format("%s 花了 %f ", alg1, spendTime1);
        System.out.println();
        System.out.format("%s 花了 %f ", alg2, spendTime2);
    }
}
