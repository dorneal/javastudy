package is.mynote.itcust3;

import java.lang.reflect.Method;

/**
 * 具体切入功能
 *
 * @author Neal
 */
public class MyAdvice implements Advice {
    private long beginTime;

    @Override
    public void beforeMethod() {
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void afterMethod(Method method) {
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + "   " + (endTime - beginTime));
    }
}
