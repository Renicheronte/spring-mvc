package ru.renicheronte.springMVC.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.renicheronte.springMVC.models.Person;
//import ru.renicheronte.springMVC.util.Util;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonDAOImpl implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> index() {
        //return jdbcTemplate.query("SELECT * FROM person", new PersonMapper());
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));

//        List<Person> people = new ArrayList<>();
//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("SELECT * FROM person");
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//            while (resultSet.next()) {
//                Person person = new Person(resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getInt("age"),
//                        resultSet.getString("email"));
//                people.add(person);
//            }
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return people;
    }

    @Override
    public Person show(int id) {

        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[] {id}, new PersonMapper())
                .stream().findAny().orElse(null);

//        Person person = null;
//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("SELECT * FROM person where id=?")) {
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            person = new Person(resultSet.getInt("id"),
//                    resultSet.getString("name"),
//                    resultSet.getInt("age"),
//                    resultSet.getString("email"));
//            resultSet.close();
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return person;
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(id, name, age, email) VALUES (?,?,?,?)",
                1, person.getName(), person.getAge(), person.getEmail());

//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(
//                "INSERT INTO person(id, name, age, email) VALUES (?,?,?,?)")) {
//            preparedStatement.setInt(1, 10);
//            preparedStatement.setString(2, person.getName());
//            preparedStatement.setInt(3, person.getAge());
//            preparedStatement.setString(4, person.getEmail());
//            preparedStatement.executeUpdate();
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
    }

    @Override
    public void update(int id, Person updatetPerson) {
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?",
                updatetPerson.getName(), updatetPerson.getAge(), updatetPerson.getEmail(), id);

//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("UPDATE person SET name=?, age=?, email=? WHERE id=?")) {
//            preparedStatement.setString(1, updatetPerson.getName());
//            preparedStatement.setInt(2, updatetPerson.getAge());
//            preparedStatement.setString(3, updatetPerson.getEmail());
//            preparedStatement.setInt(4, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("DELETE FROM person WHERE id=?")) {
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
    }
}
