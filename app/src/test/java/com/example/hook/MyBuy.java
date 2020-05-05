package com.example.hook;

/**
 * create by cy
 * time : 2020/3/10
 * version : 1.0
 * Features :
 */
public class MyBuy implements IShop {
    @Override
    public void buy() {
        System.out.print("真正的买东西");
    }
}
