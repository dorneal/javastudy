package is.mynote.unit2;

/**
 * Demonstrate a simple generic method
 *
 * @author neal
 */
public class GenMethDemo {
    /**
     * Determine if an object is in an array.
     *
     * @param x   x
     * @param y   y
     * @param <T> T
     * @param <V> V
     * @return boolean
     */
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (V aY : y) {
            if (x.equals(aY)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Use isIn() on Integers
        Integer[] nums = {1, 2, 3, 4, 5};
        if (!isIn(2, nums)) {
            System.out.println("2 is in nums");
        }
        if (!isIn(7, nums)) {
            System.out.println("2 is in nums");
        }
        System.out.println();

        //Use isIn() on Strings.
        String[] strs = {"one", "two", "three", "four", "five"};
        if (isIn("two", strs)) {
            System.out.println("Two is in strs");
        }
        if (isIn("six", strs)) {
            System.out.println("Two is in strs");
        }
    }
}
