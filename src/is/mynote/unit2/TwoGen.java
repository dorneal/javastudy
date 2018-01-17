package is.mynote.unit2;

/**
 * A simple generic class with two type
 * parameters:T and V
 *
 * @author neal
 */
public class TwoGen<T, V> {
    /**
     *
     */
    private T ob1;
    private V ob2;

    /**
     * Pass the constructor a reference to
     * an object of type T and an object of type V
     *
     * @param o1 type T
     * @param o2 type V
     */
    TwoGen(T o1, V o2) {
        this.ob1 = o1;
        this.ob2 = o2;
    }

    /**
     * Show types of T and V
     */
    void showTypes() {
        System.out.println("Type of T is " +
                ob1.getClass().getName());
        System.out.println("Type of V is " +
                ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }
}

class SimpGen {
    public static void main(String[] args) {
        TwoGen<Integer, String> tgObj =
                new TwoGen<>(99, "Generics");

        //Show the types.
        tgObj.showTypes();

        //obtain and show values.
        int v = tgObj.getOb1();
        System.out.println("value: " + v);

        String str = tgObj.getOb2();
        System.out.println("value: " + str);
    }
}