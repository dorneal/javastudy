package is.mynote.unit2;

/**
 * Demonstrate a simple lambda expression
 * A functional interface
 *
 * @author neal
 */
public interface MyNumber {
    double getValue();
}

class LambdaDemo {
    public static void main(String[] args) {
        // declare the lambda expression is simply a constant expression
        MyNumber myNumber;

        // When it is assigned to myNumber, a class instance is
        // constructed in which the lambda expression implements
        // the getValue() method in MyNumber
        myNumber = () -> 123.45;

        //Call getValue(),which is provided by the previously assigned
        // lambda expression
        System.out.println("A fixed value: " + myNumber.getValue());

        // Here, a more complex expression is used.
        myNumber = () -> Math.random() * 100;

        //These call the lambda expression in the previous line.
        System.out.println("A random value: " + myNumber.getValue());
        System.out.println("Another random value: " + myNumber.getValue());

        // A lambda expression must be compatible with the method
        // defined by the functional interface.therefore,this won't work;
        /// myNumber = () -> "123.03";
    }
}