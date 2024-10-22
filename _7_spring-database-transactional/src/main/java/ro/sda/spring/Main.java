package ro.sda.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring.config.ProjectConfig;
import ro.sda.spring.model.Product;
import ro.sda.spring.service.ProductService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            ProductService service = ctx.getBean(ProductService.class);
            service.addProduct(new Product("iphone 16", 1000));
            service.addProduct(new Product("macbook", 2000));
            service.addProduct(new Product("samsung s24", 800));

            System.out.println(service.getAllProducts());

            System.out.println("--------------------------");

            try {
                service.addWithoutTransaction(Arrays.asList(
                        new Product("mouse", 10),
                        new Product("monitor", 400)
                ));
            } catch (Throwable ex) {
                System.out.println(ex.getMessage());
            }

//            service.getAllProducts().forEach((p) -> System.out.println(p));

            List<Product> list = service.getAllProducts();

            for (var p : list) {
                System.out.println(p);
            }

            System.out.println("------------------------------");

            try {
                service.addWithTransaction(Arrays.asList(
                        new Product("tv", 1000),
                        new Product("apple watch", 500)
                ));
            } catch (Throwable ex) {
                System.out.println(ex.getMessage());
            }

            list = service.getAllProducts();

            for (var p : list) {
                System.out.println(p);
            }

        }

    }
}