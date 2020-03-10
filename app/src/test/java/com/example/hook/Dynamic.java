package com.example.hook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * create by cy
 * time : 2020/3/10
 * version : 1.0
 * Features : 动态代理
 */
public class Dynamic implements InvocationHandler {

    private Object object;

    public Dynamic(Object object) {
        this.object = object;
    }

    /**
     * @param proxy  在其上调用方法的代理实例
     * @param method 与代理实例上调用的接口方法相对应的{@code Method}实例。
     *               {@code方法}对象的声明类将是在其中声明该方法的接口，
     *               它可以是代理类通过其继承该方法的代理接口的超接口。
     * @param args   包含在代理实例上的方法调用中传递的参数值的对象数组；如果接口方法不带参数，则为{@code null}。
     *               基本类型的参数被包装在适当的基本包装类的实例中，
     *               例如{@code java.lang.Integer}或{@code java.lang.Boolean}。
     * @return 从代理实例上的方法调用返回的值。 如果接口方法的声明的返回类型是原始类型，
     * 则此方法返回的值必须是对应的原始包装器类的实例；否则，返回true。
     * 否则，它必须是可分配给声明的返回类型的类型。
     * 如果此方法返回的值为{@code null}，并且接口方法的返回类型为
     * 原语，则代理实例上的方法调用将引发{@code NullPointerException}。
     * 如果此方法返回的值与上述接口方法的声明返回类型不兼容，
     * 则代理实例上的方法调用将引发{@code ClassCastException}。
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}
