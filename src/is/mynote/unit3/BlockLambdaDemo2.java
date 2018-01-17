package is.mynote.unit3;

public class BlockLambdaDemo2 {
    public static void main(String[] args) {
        //This block lambda reverses the characters in a String
        StringFunc reverse = (str) -> {
            StringBuilder result = new StringBuilder();
            int i;
            for (i = str.length() - 1; i >= 0; i--) {
                result.append(str.charAt(i));
            }
            return result.toString();
        };

        System.out.println("lambda reversed is " +
                reverse.func("lambda"));
        System.out.println("Expression reversed is " +
                reverse.func("Expression"));
    }
}

interface StringFunc {
    String func(String n);
}
