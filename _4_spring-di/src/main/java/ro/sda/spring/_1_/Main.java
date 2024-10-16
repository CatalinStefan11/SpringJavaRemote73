package ro.sda.spring._1_;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._1_.beans.Cat;
import ro.sda.spring._1_.components.Dog;
import ro.sda.spring._1_.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Cat c1 = ctx.getBean(Cat.class);
            c1.sayMeow();

            Cat c2 = ctx.getBean(Cat.class);
            c2.sayMeow();

            Dog d1 = ctx.getBean(Dog.class);
            d1.sayHam();

            Dog d2 = ctx.getBean(Dog.class);
            d2.sayHam();
        }

    }
}
