package is.mynote.unit3;

/**
 * @author neal
 */
public class LambdasAsArgumentsDemo {

    /**
     * This method has a functional interface as the type of
     * its first parameter
     *
     * @param sf
     * @param s
     * @return String
     */
    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "lambdas add power to Java";
        String outStr;
        System.out.println("Here is input string: " + inStr);
        outStr = stringOp(String::toUpperCase, inStr);
        System.out.println("This string in upepercase:" + outStr);

        outStr = stringOp((str) -> {
            StringBuilder result = new StringBuilder();
            int i;
            for (i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) != ' ') {
                    result.append(str.charAt(i));
                }
            }
            return result.toString();
        }, inStr);

        System.out.println("The string with spaces removed :" + outStr);
    }
}

interface StringFunc2 {
    String func(String n);
}
