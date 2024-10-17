package ro.sda.spring._6_.beans;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Owner {
    @Autowired
    private Cat cat;

    public Owner() {
        System.out.println("Owner was created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Owner was created!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Owner is destroying");
    }

    public Cat getCat() {
        return cat;
    }
}
