package com.example.hook;

/**
 * create by cy
 * time : 2020/3/10
 * version : 1.0
 * Features : 静态代理
 */
public class Static implements IShop {

    private IShop innerShop;

    public Static(IShop innerShop) {
        this.innerShop = innerShop;
    }

    @Override
    public void buy() {
        innerShop.buy();
    }
}
