package ro.sda.spring._6_.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ro.sda.spring._6_.beans.Cat;
import ro.sda.spring._6_.beans.Owner;

@Configuration
public class ProjectConfig {

    @Bean
    @Scope(value = "prototype")
    public Cat cat() {
        return new Cat();
    }

    @Bean
    public Owner owner() {
        return new Owner();
    }
}
