package is.mynote.unit2;

/**
 * Java本地接口(Java Native Interface  JNI)
 * 用于链接其他语言程序代码
 *
 * @author neal
 */
public class NativeDemo {
    int i;

    public static void main(String[] args) {
        NativeDemo ob = new NativeDemo();
        ob.i = 10;
        System.out.println("This is ob.i before the native method: " + ob.i);
        ob.test();
        System.out.println("This is ob.i after the native method:" + ob.i);
    }

    /**
     * declare native method
     */
    public native void test();

    // Load DLL that contains static method
    static {
        System.loadLibrary("NativeDemo");
    }
}
