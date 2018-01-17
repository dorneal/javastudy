package is.mynote.unit3;

public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumbericFunc factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("the factorial of 3 is " +
                factorial.func(3));
        System.out.println("the factorial of 5 is " +
                factorial.func(5));
    }
}

interface NumbericFunc {
    int func(int n);
}