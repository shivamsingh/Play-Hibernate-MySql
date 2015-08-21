package model;

import play.db.jpa.JPA;

public class ContactRepository {
    public static void create(Contact contact) {
        JPA.em().persist(contact);
    }
}
