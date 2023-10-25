package ru.renicheronte.springMVC.dao;


import org.springframework.stereotype.Repository;
import ru.renicheronte.springMVC.models.Person;

import java.util.List;


@Repository
public class PersonDAOImpl implements PersonDAO {
    private static int peopleCounter;
    private final List<Person> people;

    public PersonDAOImpl(List<Person> people) {
        this.people = people;
        people.add(new Person(++peopleCounter, "Ivan"));
        people.add(new Person(++peopleCounter, "Petr"));
        people.add(new Person(++peopleCounter, "Sasha"));
        people.add(new Person(++peopleCounter, "Oleg"));
    }

    @Override
    public List<Person> index() {
        return people;
    }

    @Override
    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(Person person) {
        person.setId(++peopleCounter);
        people.add(person);
    }
}
