package is.mynote.unit2;

/**
 * NoGen is functionally equivalent to Gen
 * but does not use generics.
 *
 * @author neal
 */
public class NonGen {
    /**
     * ob is now of type Object
     */
    private Object ob;

    /**
     * Pass the constructor a reference to
     * an object of type object.
     *
     * @param o object
     */
    NonGen(Object o) {
        this.ob = o;
    }

    /**
     * @return type of Object
     */
    Object getOb() {
        return ob;
    }

    /**
     * Show type of ob
     */
    void showType() {
        System.out.println("Type of ob is " +
                ob.getClass().getName());
    }
}

/**
 * Demonstrate the non-generic class.
 */
class NonGenDemo {
    public static void main(String[] args) {
        NonGen iob;

        // Create NonGen Object and store
        // an Integer in it.Autoboxing still occurs.
        iob = new NonGen(88);

        //Show the type of data used by iob
        iob.showType();

        // Get the value of ob
        // This time, a cast is necessary
        int v = (Integer) iob.getOb();
        System.out.println("Values: " + v + "\n");

        //Create NoGen Object and
        // an String in it.
        NonGen strOb = new NonGen("Non-Generics Test");

        // Show the type of data used by strOb
        strOb.showType();

        //Get the value of strOb.
        //Again,notice that a cast is necessary
        String str = (String) strOb.getOb();

        System.out.println("Value: " + str);

        //This compiles , but is conceptually wrong!
        //iob = strOb;
        //v = (Integer) iob.getOb();
    }
}
