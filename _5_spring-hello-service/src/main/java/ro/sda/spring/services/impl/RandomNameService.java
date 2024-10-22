package ro.sda.spring.services.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ro.sda.spring.services.NameService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// @Primary makes this BEAN the default bean to be injected when a bean
// of this type is required and no other info is provided
@Service("random")
//@Primary
public class RandomNameService implements NameService {
    private List<String> names = Arrays.asList("Messi", "Neymar", "Ronaldo", "Mbappe");

    public RandomNameService() {
        System.out.println("RandomNameService constructor called!");
    }

    @Override
    public String getName() {
        int i = new Random().nextInt(4);
        return names.get(i);
    }
}
