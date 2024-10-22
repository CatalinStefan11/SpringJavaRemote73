package ro.sda.spring.proxy;

public class ServiceProxy implements Service {
    private final RealService realService;

    public ServiceProxy() {
        this.realService = new RealService();
    }

    // we override the method from the interface, and we added some extra behaviour, and we also called
    // the original method from the RealService the does the real work
    @Override
    public void performOperation() {
        System.out.println("Logging: Operation is about to start.");

        realService.performOperation();

        System.out.println("Logging: Operation has completed!");
    }
}
