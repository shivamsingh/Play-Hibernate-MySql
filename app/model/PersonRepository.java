package model;

import play.db.jpa.JPA;

import java.util.Collection;
import java.util.List;

public class PersonRepository {
    public static void create(Person person) {
        JPA.em().persist(person);
    }

    public static Person find(int id) {
        return JPA.em().find(Person.class, id);
    }

    public static List all() {
        return JPA.em().createQuery("SELECT e FROM Person e").getResultList();
    }
}
