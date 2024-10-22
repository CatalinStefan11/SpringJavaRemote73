package ro.sda.spring.proxy;

public class Main {

    public static void main(String[] args) {

//        Service myService = new RealService();
//        myService.performOperation();

        Service anotherService = new ServiceProxy();
        anotherService.performOperation();

    }
}
