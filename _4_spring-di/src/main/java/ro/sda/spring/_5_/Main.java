package ro.sda.spring._5_;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._5_.components.Dog;
import ro.sda.spring._5_.components.Owner;
import ro.sda.spring._5_.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try(var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Owner o = ctx.getBean(Owner.class);

            System.out.println(o.getName());
            System.out.println(o.getDog());

            Dog d = ctx.getBean(Dog.class);
            System.out.println(d);

        }
    }

}
