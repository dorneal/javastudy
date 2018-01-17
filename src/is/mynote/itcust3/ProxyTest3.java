package is.mynote.itcust3;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 动态代理测试3
 *
 * @author Neal
 */
public class ProxyTest3 {
    public static void main(String[] args) {
        ArrayList target = new ArrayList();
        Collection<String> proxy1 = (Collection<String>) getProxy(target, new MyAdvice());
        proxy1.add("jack");
        proxy1.add("neal");
        proxy1.add("rose");
        System.out.println(proxy1.size());
        System.out.println(proxy1.toString());
    }

    /**
     * 动态代理
     *
     * @param target 目标对象
     * @param advice 切面功能
     * @return Object
     */
    private static Object getProxy(final Object target, final Advice advice) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            advice.beforeMethod();
            proxy = method.invoke(target, args);
            advice.afterMethod(method);
            return proxy;
        });
    }
}
