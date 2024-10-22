package ro.sda.spring.services.impl;

import ro.sda.spring.services.NameService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RomanianNameService implements NameService {
    private List<String> names = Arrays.asList("Ion", "Vasile", "George", "Dumitru", "Elena", "Maria");

    @Override
    public String getName() {
        int i = new Random().nextInt(6);
        return names.get(i);
    }
}
