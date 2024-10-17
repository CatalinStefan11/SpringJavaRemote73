package ro.sda.spring._6_;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._6_.beans.Cat;
import ro.sda.spring._6_.beans.Owner;
import ro.sda.spring._6_.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try(var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            System.out.println("Context fully initialized!");

            Cat c1 = ctx.getBean(Cat.class);
            System.out.println(c1);

            Cat c2 = ctx.getBean(Cat.class);
            System.out.println(c2);

            Cat c3 = ctx.getBean(Cat.class);
            System.out.println(c3);

            System.out.println("--------------------");

            Owner o1 = ctx.getBean(Owner.class);
            System.out.println(o1);

            System.out.println(o1.getCat());

            System.out.println("Context before closing!");
        }
        System.out.println("Context closed!");
    }
}
