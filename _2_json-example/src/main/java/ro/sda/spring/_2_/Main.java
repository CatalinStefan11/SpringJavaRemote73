package ro.sda.spring._2_;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;


// Exceptions -> checked / unchecked
// checked -> exceptions that extends from Exception class (they need to be handled at compile time)
// unchecked -> exceptions that extends from RuntimeException class (they don't require to be handled)
public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car("bmw", "yellow", 200, true);

        System.out.println(mapper.writeValueAsString(car));

        List<Car> carList = Arrays.asList(
                new Car("bmw", "yellow", 200, true),
                new Car("toyota", "black", 70, false)
        );

        System.out.println(mapper.writeValueAsString(carList));
    }
}
