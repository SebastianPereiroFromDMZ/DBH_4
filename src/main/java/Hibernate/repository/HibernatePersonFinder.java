package Hibernate.repository;

import Hibernate.model.Person;
import Hibernate.model.PersonPK;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class HibernatePersonFinder implements PersonFinder {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Person> getPersonsByCity(String city) {
        List<Person> personList = new ArrayList<>();
        //feelTheTable();
        String sql = "select* from public.person";
        List<Object[]> rows = entityManager.createNativeQuery(sql).getResultList();


        for (Object[] row : rows) {
            PersonPK personPK = new PersonPK((String) row[1], (String) row[2], (Integer) row[0]);
            Person person = new Person(personPK, (String) row[4], (String) row[3]);
            personList.add(person);
        }

        List<Person> persons = personList.stream()
                .filter(person -> Objects.equals(person.getCity(), city)).toList();

        return persons;
    }

    @Transactional
    public void feelTheTable() {
        Person firstPerson = Person.builder()
                .personPK(PersonPK.builder().age(25).name("Nikola").surname("Holopenya").build())
                .city("Moscow")
                .phone("2123311")
                .build();
        entityManager.persist(firstPerson);

        Person secondPerson = Person.builder()
                .personPK(PersonPK.builder().age(56).name("Sofa").surname("Solochak").build())
                .city("London")
                .phone("421124")
                .build();
        entityManager.persist(secondPerson);

        Person thirdPerson = Person.builder()
                .personPK(PersonPK.builder().age(21).name("Bolon").surname("Derraw").build())
                .city("Moscow")
                .phone("990012")
                .build();
        entityManager.persist(thirdPerson);

        Person fourthPerson = Person.builder()
                .personPK(PersonPK.builder().age(12).name("Kris").surname("NOlf").build())
                .city("Moscow")
                .phone("212331212")
                .build();
        entityManager.persist(fourthPerson);

        Person fifthPerson = Person.builder()
                .personPK(PersonPK.builder().age(87).name("Bakka").surname("Nox").build())
                .city("SPB")
                .phone("992912213")
                .build();
        entityManager.persist(fifthPerson);
    }
}
