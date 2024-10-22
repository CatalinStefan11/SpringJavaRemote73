package ro.sda.spring.services.impl;

import org.springframework.stereotype.Service;
import ro.sda.spring.services.NameService;

// The name "simple" in this case sets the name of the BEAN/COMPONENT that is managed by spring and resides in ApplicationContext
// and is the name that is recognizable by Spring
@Service("simple")
public class SimpleNameService implements NameService {

    public SimpleNameService() {
        System.out.println("SimpleNameService constructor called!");
    }

    @Override
    public String getName() {
        return "Catalin";
    }
}

/*
-> @Controller / @RestController (layer that interacts with web)
-> @Service (business logic layer)
-> Repository (database layer)
-> Component (none of the above)
 */
