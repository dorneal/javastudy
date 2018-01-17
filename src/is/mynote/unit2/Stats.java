package is.mynote.unit2;

/**
 * In this version of State,the type argument for
 * T must be either Numver , or a class derived
 * form Number
 *
 * @param <T>
 * @author neal
 */
public class Stats<T extends Number> {
    /**
     * Array of Number or subclass
     */
    private T[] nums;

    /**
     * Pass the constructor a reference to
     * an array of type Number or subclass
     *
     * @param o type of T
     */
    Stats(T[] o) {
        this.nums = o;
    }

    /**
     * @return Type double in all cases
     */
    double averAge() {
        double sum = 0.0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum / nums.length;
    }

    /**
     * Determine if two averages are the same.
     * Notice the use of the wildcard.
     *
     * @param ob type of unknown
     * @return boolean
     */
    boolean sameAvg(Stats<?> ob) {
        return averAge() == ob.averAge();
    }
}

class BoundsDemo {
    public static void main(String[] args) {
        Integer[] intNums = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<>(intNums);
        double v = iob.averAge();
        System.out.println("iob average is " + v);

        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<>(dnums);
        double w = dob.averAge();
        System.out.println("dob average is " + w);

        //This won't compile because String is not a
        //subclass of Number
        //String[] strs = {"1","2","3","4"};
        //Stats<String> strob = new Stats<>(strs);
        //double x = strob.averAge();
        //System.out.println("strob average is " + x);

        Float[] fnums = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
        Stats<Float> fob = new Stats<>(fnums);
        double x = fob.averAge();
        System.out.println("fob average is " + x);

        //See which arrays have same average.
        System.out.println("Averages of iob and dob ");
        if (iob.sameAvg(dob)) {
            System.out.println("are the same");
        } else {
            System.out.println("different");
        }
        System.out.println("Averages of iob and fob");
        if (iob.sameAvg(fob)) {
            System.out.println("are the same.");
        } else {
            System.out.println("differ");
        }
    }
}