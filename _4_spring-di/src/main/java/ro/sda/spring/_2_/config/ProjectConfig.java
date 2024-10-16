package ro.sda.spring._2_.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.spring._2_.beans.Dog;
import ro.sda.spring._2_.beans.Owner;

@Configuration
public class ProjectConfig {

    @Bean
    public Owner owner1() {
        Owner o = new Owner();
        o.setDog(dog());
        o.setName("John");
        return o;
    }

    @Bean
    public Owner owner2() {
        Owner o = new Owner();
        o.setDog(dog());
        o.setName("Alibaba");
        return o;
    }

    @Bean
    public Dog dog() {
        return new Dog("Lexy");
    }
}
