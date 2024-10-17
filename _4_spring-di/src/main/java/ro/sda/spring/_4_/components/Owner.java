package ro.sda.spring._4_.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Owner {
    private String name;


    // @Autowired dependency injection by field
    private Dog dog;

    public Owner() {
        System.out.println("Owner constructor called!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    @Autowired // -> dependency injection by setter
    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
