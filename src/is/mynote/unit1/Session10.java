package is.mynote.unit1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射实现调用类的方法
 *
 * @author neal
 */
public class Session10 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase");
        System.out.println(m.invoke(str));
    }
}

