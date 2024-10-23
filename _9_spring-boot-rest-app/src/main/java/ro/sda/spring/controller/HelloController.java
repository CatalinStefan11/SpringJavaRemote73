package ro.sda.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // request parameter
    // request url example: http://localhost:8080/hello/Cristiano
    @GetMapping("/hello/{n}")
    public String hello(@PathVariable("n") String name) {
        return "Hello, " + name + "!";
    }

    // query parameter
    // request url example: http://localhost:8080/other-hello?name=Cristiano&age=100
    @GetMapping("/other-hello")
    public String helloQueryParam(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        return "Hello, " + name + "! I am " + age + " years old";
    }
}
