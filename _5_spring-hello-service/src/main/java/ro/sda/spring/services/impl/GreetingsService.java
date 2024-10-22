package ro.sda.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.spring.services.HelloService;
import ro.sda.spring.services.NameService;

@Service
public class GreetingsService implements HelloService {

    // @Qualifier tells spring which bean to injected here by specifying the name of the bean from AppContext
    @Autowired
//    @Qualifier("romanian")
    private NameService nameService;

    public GreetingsService() {
        System.out.println("GreetingsService constructor called.");
    }

    @Override
    public void sayHello() {
        String name = nameService.getName();
        System.out.println("Hello, " + name + "!");
    }
}
