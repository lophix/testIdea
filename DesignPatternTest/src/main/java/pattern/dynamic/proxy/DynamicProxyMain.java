package pattern.dynamic.proxy;

import java.lang.reflect.Proxy;

/**
 * access class
 *
 * @author xuj
 * @version 1.0.1
 * @since 2017-03-24-9:02
 */
public class DynamicProxyMain {
    public static void main(String[] args) {
        IAnimal tiger = new Tiger();
        IAnimal monkey = new Monkey();
        DynamicProxy tigerProxy = new DynamicProxy(tiger);
        DynamicProxy monkeyProxy = new DynamicProxy(monkey);
        IAnimal proxyTiger = (IAnimal) Proxy.newProxyInstance(IAnimal.class.getClassLoader(), new Class[]{IAnimal.class}, tigerProxy);
        IAnimal proxyMonkey = (IAnimal) Proxy.newProxyInstance(IAnimal.class.getClassLoader(), new Class[]{IAnimal.class}, monkeyProxy);
        proxyTiger.eat();
        proxyTiger.active();
        proxyMonkey.eat();
        proxyMonkey.active();
    }
}
