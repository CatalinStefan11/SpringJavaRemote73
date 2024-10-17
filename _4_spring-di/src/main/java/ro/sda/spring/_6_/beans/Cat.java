package ro.sda.spring._6_.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Cat {
    public Cat() {
        System.out.println("Cat constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Cat was created!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Cat is destroying!");
    }

    public void sayMeow() {
        System.out.println("Meow!");
    }
}
