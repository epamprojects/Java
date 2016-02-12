package com.company;

import com.company.ConnectionFactoryClasses.ConnectionFactoryFactory;
import com.company.UserClasses.User;
import com.company.UserDaoClasses.UserDAOClass;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        User newUser = new User(5);
        newUser.setEmail("email");
        newUser.setLogin("login");

        UserDAOClass userDao = new UserDAOClass();
        userDao.setConnection(ConnectionFactoryFactory.FactoryType.JDBC);

        List<User> users = userDao.selectAll();
        System.out.println(users.size());

        userDao.insert(newUser);
        System.out.println(users.size());
    }
}
