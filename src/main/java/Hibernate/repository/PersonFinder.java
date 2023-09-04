package Hibernate.repository;

import Hibernate.model.Person;

import java.util.List;

public interface PersonFinder {

    List<Person> getPersonsByCity(String city);
}
