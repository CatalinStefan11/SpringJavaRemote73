package ro.sda.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring.config.ProjectConfig;
import ro.sda.spring.services.HelloService;
import ro.sda.spring.services.NameService;

public class Main {
    public static void main(String[] args) {

        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            HelloService service = c.getBean(HelloService.class);
            service.sayHello();

            System.out.println("---------------------------");

            NameService simple = c.getBean("simple", NameService.class);
            System.out.println(simple.getName());
        }
    }
}
