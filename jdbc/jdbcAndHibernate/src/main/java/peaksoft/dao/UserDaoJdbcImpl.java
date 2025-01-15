package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    private Connection connection = Util.getConnection();
    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
    String sql = """
            create table if not exists users (id serial primary key,
            name varchar not null,
            last_name varchar not null,
            age integer not null);
            """;
        try (
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void saveUser(String name, String lastName, byte age) {
        String sql = """
            INSERT INTO users (name, last_name, age) 
            VALUES (?, ?, ?);
            """;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("Table saved");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String sql = """
                select * from users;
                """;
        try (Statement statement = connection.createStatement()){
           ResultSet resultSet = statement.executeQuery(sql);
           while (resultSet.next()){
               User user = new User();
               user.setId(resultSet.getLong("id"));
               user.setName(resultSet.getString("name"));
               user.setLastName(resultSet.getString("last_name"));
               user.setAge(resultSet.getByte("age"));
               users.add(user);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void removeUserById(long id) {
        String sql = """
                delete from users where id = ?;
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("User deleted");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cleanUsersTable() {
        String sql = """
                truncate table users;
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table cleaned");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String sql = """
                drop table if exists users;
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table dropped");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}