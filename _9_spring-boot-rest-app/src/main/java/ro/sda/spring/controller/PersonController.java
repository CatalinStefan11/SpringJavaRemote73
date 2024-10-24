package ro.sda.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.spring.model.Person;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public Person getPerson() {
        return new Person("Catalin", 26);
    }

    @GetMapping("/get-entity")
    public ResponseEntity<Person> getPersonEntity() {
        Person p = new Person("Catalin", 26);
        return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
    }

}
