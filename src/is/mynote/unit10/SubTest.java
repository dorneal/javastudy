package is.mynote.unit10;

public class SubTest extends SuperTest {
    public static void main(String[] args) {
        System.out.println(new SubTest().name);
        System.out.println(SubTest.str);
        new SubTest().run();
        SubTest.sing();
        System.out.println(7 >>> 1);
    }
}
