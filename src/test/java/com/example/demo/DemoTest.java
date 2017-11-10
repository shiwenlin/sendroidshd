package com.example.demo;

public class DemoTest {
    public static  int a = 10;

    static {
        a = 10;
        System.out.println("父类的静态代码块在执行a="+a);
    }

    {
        a = 8;
        System.out.println("父类的非静态代码块在执行a="+a);
    }

    public DemoTest() {
        this("a在带参够着方法："+DemoTest.a);
        System.out.println(a);
        System.out.println("午餐构造" +a);
    }

    public DemoTest(String n) {
       System.out.println(n);
       System.out.println(a);
    }

}
