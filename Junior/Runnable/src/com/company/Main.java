package com.company;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        ClassLoader cl = Test.class.getClassLoader();
        Class<?>[] interfaces = {Runnable.class};

        InvocationHandler handler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(proxy);
                System.out.println(method);
                return null;
            }
        };

        Runnable runnable = (Runnable) Proxy.newProxyInstance(cl, interfaces, handler);

        runnable.run();

    }
}
