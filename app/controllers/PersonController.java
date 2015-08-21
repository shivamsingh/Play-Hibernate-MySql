package controllers;

import model.Contact;
import model.ContactRepository;
import model.Person;
import model.PersonRepository;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Collections;

public class PersonController extends Controller {

    @Transactional
    public Result create(String name) {
        Person person = new Person(name);
        Contact contact = new Contact("Goregaon");
        ContactRepository.create(contact);

        person.setContacts(Collections.singletonList(contact));
        PersonRepository.create(person);
        return ok(Json.toJson(person));
    }

    @Transactional(readOnly = true)
    public Result show(int id) {
        System.out.print("id:" + id);
        return ok(Json.toJson(PersonRepository.find(id)));
    }

    @Transactional(readOnly = true)
    public Result index() {
        return ok(Json.toJson(PersonRepository.all()));
    }
}
