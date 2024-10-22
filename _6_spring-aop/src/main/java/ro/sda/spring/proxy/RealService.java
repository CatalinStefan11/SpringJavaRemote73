package ro.sda.spring.proxy;

public class RealService implements Service {

    // the initial intent is to enrich this method with new functionality,
    // but I am not allowed to modify this method (this method could be part of a library that I cannot modify)
    @Override
    public void performOperation() {
        System.out.println("Performing the actual operation in RealService");
    }
}
