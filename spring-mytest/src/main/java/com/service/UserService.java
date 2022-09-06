package com.service;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userService")
@Scope("prototype")
public class UserService implements BeanNameAware, InitializingBean,UserInterface {

    @Autowired
    public OrderService orderService;

    private String beanName;

    private String xxx;


    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean");
    }

    public void setXxx(){

    }

    @Override
    public void test(){
        System.out.println(orderService);
    }
}
