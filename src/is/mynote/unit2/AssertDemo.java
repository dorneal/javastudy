package is.mynote.unit2;

/**
 * 使用断言
 *
 * @author neal
 */
public class AssertDemo {
    private static int val = 3;

    private static int getNum() {
        return val--;
    }

    public static void main(String[] args) {
        int n;
        for (int i = 0; i < 10; i++) {
            n = getNum();
            assert n > 0 : "n is negative";
            System.out.println("n is " + n);
        }
    }
}
