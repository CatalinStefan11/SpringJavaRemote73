package ro.sda.spring._1_.components;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    public Dog() {
        System.out.println("Dog constructor called!");
    }

    public void sayHam() {
        System.out.println("Ham ham");
    }
}
