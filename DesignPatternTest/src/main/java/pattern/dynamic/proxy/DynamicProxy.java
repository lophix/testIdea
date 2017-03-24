package pattern.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * dynamic proxy class
 *
 * @author xuj
 * @version 1.0.1
 * @since 2017-03-23-18:13
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj;
        if (target instanceof Monkey) {
            System.out.println("before method");
            obj = method.invoke(target, args);
            System.out.println("after method");
        } else {
            obj = method.invoke(target, args);
        }
        return obj;
    }

}
