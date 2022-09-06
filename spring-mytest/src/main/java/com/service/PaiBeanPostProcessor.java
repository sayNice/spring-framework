package com.service;


import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class PaiBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("PaiBeanPostProcessor.postPorcessorBeforInitialization");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(String beanName, Object bean) {
        if(beanName.equals("userService")){
            Object proxyInstance = Proxy.newProxyInstance(PaiBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("前面逻辑");
                    return method.invoke(bean,args);
                }
            });
            return proxyInstance;
        }
        return bean;
    }
}
