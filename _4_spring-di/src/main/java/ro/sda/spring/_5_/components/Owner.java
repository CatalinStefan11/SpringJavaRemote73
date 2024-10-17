package ro.sda.spring._5_.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    @Value("John")
    private String name;
    private Dog dog;

    // @Autowired -> this annotation is optional for constructor dependency injection
    // because spring always calls the constructor to initialize beans/components, and
    // it will be aware that it needs to provide the needed dependencies in constructor
    public Owner(Dog dog) {
        this.dog = dog;
        System.out.println("Owner constructor called!");
    }

    public String getName() {
        return name;
    }

    public Dog getDog() {
        return dog;
    }
}
