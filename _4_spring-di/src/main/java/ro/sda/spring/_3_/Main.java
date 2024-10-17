package ro.sda.spring._3_;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._3_.beans.Dog;
import ro.sda.spring._3_.beans.Owner;
import ro.sda.spring._3_.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        // var is used with LOCAL variables (cannot be used with instance variables) and should be initialized
        // all the time in order for the type inference to work
        try(var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Owner o = ctx.getBean(Owner.class);

            Dog d = o.getDog();
            System.out.println(d);

            Dog d2 = ctx.getBean(Dog.class);
            System.out.println(d2);

        }
    }
}
