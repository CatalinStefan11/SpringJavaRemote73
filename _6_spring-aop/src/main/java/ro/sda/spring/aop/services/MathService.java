package ro.sda.spring.aop.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    public int add(int a, int b) {
        if ((a + b) % 2 == 0) {
            throw new RuntimeException("Exception occurred");
        }
        return a + b;
    }

    public int subtract(int a, int b) {
        if ((a - b) % 2 == 0) {
            throw new RuntimeException("Exception occurred");
        }
        return a - b;
    }

    public int multiply(int a, int b) {
        if ((a * b) % 2 == 0) {
            throw new RuntimeException("Exception occurred");
        }
        return a * b;
    }

    public int divide(int a, int b) {
        if ((a / b) % 2 == 0) {
            throw new RuntimeException("Exception occurred");
        }
        return a / b;
    }
}
