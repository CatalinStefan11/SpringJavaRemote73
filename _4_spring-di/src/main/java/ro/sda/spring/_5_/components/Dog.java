package ro.sda.spring._5_.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog {

    // @Values tells spring that it needs to inject a values in this string
    // for this case the value is hardcoded here, and it will be the name Pit
    @Value("Pit")
    private String name;

    public Dog() {
        System.out.println("Dog constructor called!");
    }
}
