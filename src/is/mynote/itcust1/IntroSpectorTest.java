package is.mynote.itcust1;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用内省
 *
 * @author neal
 */
public class IntroSpectorTest {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        ReflectPoint pt1 = new ReflectPoint(3, 5);
        String propertyName = "x";
        /* "x"-->"X"-->"getX"-->"MethodGetX" */
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, pt1.getClass());
        Method methodGetX = pd.getReadMethod();
        Object retVal = methodGetX.invoke(pt1);
        System.out.println(retVal);

        Method methodSetX = pd.getWriteMethod();
        methodSetX.invoke(pt1,8);

        System.out.println(pt1.getX());
    }
}
