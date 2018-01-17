package is.mynote.unit2;

/**
 * A simple generic class
 * Here, T is a type parameter that
 * will be replaced by a real type
 * when an object of type Gen is created
 *
 * @param <T>
 * @author neal
 */
public class Gen<T> {
    /**
     * declare an object of type T
     */
    private T ob;

    /**
     * Pass the constructor a reference to
     * an object of type T
     *
     * @param o object
     */
    Gen(T o) {
        this.ob = o;
    }

    /**
     * @return ob
     */
    T getOb() {
        return ob;
    }

    /**
     * Show type of T
     */
    void showType() {
        System.out.println("Type of T is " + ob.getClass()
                .getName());
    }
}

class GenDemo {
    public static void main(String[] args) {
        // create a Gen reference for integers
        Gen<Integer> iob;

        // create a Gen<Integer> object and assign its
        // reference to iob.Notice the use of autoboxing
        // to encapsulate the value 88 within an Integer object.
        iob = new Gen<>(88);

        // Show the type of data used by iob.
        iob.showType();

        // Get the value in iob.Notice that
        // no cast is needed.
        int v = iob.getOb();
        System.out.println("Values: " + v);

        System.out.println();

        //Create a Gen object for Strings
        Gen<String> strOb = new Gen<>("Generics Test");

        // Show the type of data used by strOb
        strOb.showType();

        // Get the value of strOb.Again,notice
        // that no cast is needed.
        String str = strOb.getOb();
        System.out.println("Values: " + str);
    }
}