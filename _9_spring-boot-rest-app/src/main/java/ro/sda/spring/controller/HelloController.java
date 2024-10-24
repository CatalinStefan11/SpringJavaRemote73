package ro.sda.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.model.Person;

@Slf4j
@RestController
public class HelloController {

    // path parameter
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

    @GetMapping("/goodbye")
    public String goodbye(@RequestHeader("name") String name) {
        return "Goodbye, " + name + "!";
    }


    @PostMapping("/solong")
    public String solong(@RequestBody Person p) {
        log.warn(p.toString());
        return "So long, " + p.getName() + "!";
    }
}
