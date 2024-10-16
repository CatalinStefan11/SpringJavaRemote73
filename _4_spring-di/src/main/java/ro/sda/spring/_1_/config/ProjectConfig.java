package ro.sda.spring._1_.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ro.sda.spring._1_.beans.Cat;

@Configuration
@ComponentScan("ro.sda.spring._1_.components")
public class ProjectConfig {

    public ProjectConfig() {
        System.out.println("ProjectConfig constructor called!");
    }

    // this cat is going to be a component (bean) that is managed by spring
    @Bean
    public Cat cat() {
        return new Cat();
    }
}
