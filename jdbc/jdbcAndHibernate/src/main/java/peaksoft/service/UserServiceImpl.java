package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
//    UserDao userDao = new UserDaoJdbcImpl();
    UserDao userDaoHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }

//    public void saveUser(User user) {
//          userDaoHibernate.saveUser(user);
//        userDao.saveUser("Adi", "Kulov", (byte)23);
//        userDao.saveUser("Bek", "Saparov", (byte)28);
//        userDao.saveUser("David", "Bobulov", (byte)21);
//        userDao.saveUser("Elij", "Baelov", (byte)29)
    }

