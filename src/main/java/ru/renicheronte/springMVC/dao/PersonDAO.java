package ru.renicheronte.springMVC.dao;

import ru.renicheronte.springMVC.models.Person;

import java.util.List;
public interface PersonDAO {
    List<Person> index();
    Person show(int id);

    void save(Person person);
    void update(int id, Person updatetPerson);
    void delete(int id);

}
