package Hibernate.repository;

import Hibernate.model.Person;
import Hibernate.model.PersonPK;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernatePersonFinder implements PersonFinder {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Person> getPersonsByCity(String city) {

//        //feelTheTable();

        String hql = "FROM Person where city = :city_of_living";
        Query s = entityManager.createQuery(hql);
        s.setParameter("city_of_living", city);
        List<Person> personsList = s.getResultList();

        return personsList;
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
