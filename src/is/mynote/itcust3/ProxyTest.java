package is.mynote.itcust3;

import java.lang.reflect.*;
import java.util.Collection;

/**
 * 代理练习
 *
 * @author Neal
 */
public class ProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Collection> clazzProxy = (Class<Collection>) Proxy.getProxyClass(Collection.class.getClassLoader());
        System.out.println(clazzProxy.getName());
        Constructor[] constructors = clazzProxy.getConstructors();
        System.out.println("---------------Constructor list------------------");
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            StringBuilder stringBuilder = new StringBuilder(name);
            stringBuilder.append('(');
            Class[] clazzParams = constructor.getParameterTypes();
            for (Class c : clazzParams) {
                stringBuilder.append(c.getName()).append(',');
            }
            if (clazzParams.length != 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(')');
            System.out.println(stringBuilder.toString());
        }
        System.out.println("---------------Method list------------------");
        Method[] methods = clazzProxy.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            StringBuilder stringBuilder = new StringBuilder(name);
            stringBuilder.append('(');
            Class[] clazzParams = method.getParameterTypes();
            for (Class c : clazzParams) {
                stringBuilder.append(c.getName()).append(',');
            }
            if (clazzParams.length != 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(')');
            System.out.println(stringBuilder);
        }

        Constructor<Collection> constructor = clazzProxy.getConstructor(InvocationHandler.class);
        class MyInvocationHandler1 implements InvocationHandler {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        }
        Collection collection = constructor.newInstance(new MyInvocationHandler1());
        constructor.newInstance((InvocationHandler) (proxy, method, args1) -> null);
        System.out.println(collection.toString());
        System.out.println(collection.size());
    }
}
