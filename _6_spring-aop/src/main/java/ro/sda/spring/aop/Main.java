package ro.sda.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring.aop.config.ProjectConfig;
import ro.sda.spring.aop.services.MathService;

public class Main {

    public static void main(String[] args) {


        try (var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            MathService service = ctx.getBean(MathService.class);

            int res = service.add(1, 2);
            System.out.println(res);

            System.out.println("----------------------");
            res = service.subtract(3, 2);
            System.out.println(res);


            System.out.println("----------------------");
            res = service.multiply(3, 3);
            System.out.println(res);


            System.out.println("----------------------");
            try {
                res = service.divide(8, 4);
            } catch (Throwable ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(res);

            System.out.println("Program ended!");

        }
    }
}
