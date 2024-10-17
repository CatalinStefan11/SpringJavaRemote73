package ro.sda.spring._5_.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ro.sda.spring._5_.components")
public class ProjectConfig {

    public ProjectConfig() {
        System.out.println("ProjectConfig constructor called!");
    }
}
