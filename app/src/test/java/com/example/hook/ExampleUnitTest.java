package com.example.hook;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        // 动态代理
        IShop shop = new MyBuy();
        Dynamic dynamic = new Dynamic(shop);
        IShop proxy = (IShop) Proxy.newProxyInstance(shop.getClass().getClassLoader(), new Class[]{IShop.class}, dynamic);
        proxy.buy();

        // 静态代理
        Static s = new Static(new MyBuy());
        s.buy();
    }


}