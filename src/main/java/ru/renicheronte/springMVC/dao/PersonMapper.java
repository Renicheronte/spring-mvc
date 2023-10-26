package ru.renicheronte.springMVC.dao;


import org.springframework.jdbc.core.RowMapper;
import ru.renicheronte.springMVC.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper <Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("age"),
                resultSet.getString("email"));
        return person;
    }
}
