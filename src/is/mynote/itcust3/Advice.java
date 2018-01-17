package is.mynote.itcust3;

import java.lang.reflect.Method;

/**
 * 功能
 *
 * @author Neal
 */
public interface Advice {
    /**
     * 前切点
     */
    void beforeMethod();

    /**
     * 后切点
     *
     * @param method Method
     */
    void afterMethod(Method method);
}
