package ro.sda.spring._4_;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._4_.components.Owner;
import ro.sda.spring._4_.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try(var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Owner o = ctx.getBean(Owner.class);
            System.out.println(o.getDog());

        }

    }
}
