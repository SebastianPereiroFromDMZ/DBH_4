package Hibernate.controller;

import Hibernate.model.Person;
import Hibernate.repository.HibernatePersonFinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Controller {

    private final HibernatePersonFinder hibernatePersonFinder;

    public Controller(HibernatePersonFinder hibernatePersonFinder) {
        this.hibernatePersonFinder = hibernatePersonFinder;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getSqlSetup(@RequestParam String city) {
        return hibernatePersonFinder.getPersonsByCity(city);
    }
}
