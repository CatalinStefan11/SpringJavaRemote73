package ro.sda.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ro.sda.spring.services.NameService;
import ro.sda.spring.services.impl.RomanianNameService;

@ComponentScan("ro.sda.spring.services.impl")
@Configuration
public class ProjectConfig {

    @Bean
    @Primary
    public NameService romanian() {
        return new RomanianNameService();
    }
}
