package ro.sda.spring._2_;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._2_.beans.Dog;
import ro.sda.spring._2_.beans.Owner;
import ro.sda.spring._2_.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Dog d = ctx.getBean(Dog.class);
            System.out.println(d);

            Owner owner1 = ctx.getBean("owner1", Owner.class);
            System.out.println(owner1);

            Dog d1 = owner1.getDog();
            System.out.println(d1);

            Owner owner2 = ctx.getBean("owner2", Owner.class);
            System.out.println(owner2);

            Dog d2 = owner2.getDog();
            System.out.println(d2);
        }
    }
}
