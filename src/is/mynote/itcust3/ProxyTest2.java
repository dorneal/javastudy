package is.mynote.itcust3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 代理测试2
 *
 * @author Neal
 */
public class ProxyTest2 {
    public static void main(String[] args) {
        Collection proxy1 = (Collection) Proxy.newProxyInstance(Collection.class.getClassLoader(), new Class[]{Collection.class}, new InvocationHandler() {
            ArrayList<String> arrayList = new ArrayList<>();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long beginTime = System.currentTimeMillis();
                proxy = method.invoke(arrayList, args);
                long endTime = System.currentTimeMillis();
                System.out.println(method.getName() + "   " + (endTime - beginTime));
                return proxy;
            }
        });
        proxy1.add("neal");
        proxy1.add("jack");
        proxy1.add("rose");
        System.out.println(proxy1.size());
        System.out.println(proxy1.toString());
    }
}
