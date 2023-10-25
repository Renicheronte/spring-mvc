package ru.renicheronte.springMVC.dao;

import org.springframework.stereotype.Component;
import ru.renicheronte.springMVC.models.Person;

import java.util.List;
public interface PersonDAO {
    public List<Person> index();
    public Person show(int id);

    public void save(Person person);

}
