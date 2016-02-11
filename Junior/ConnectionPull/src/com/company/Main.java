package com.company;

import com.company.ConnectionFactoryClasses.ConnectionFactoryFactory;
import com.company.UserDaoClasses.UserDAOCJdbc;
import com.company.interfaces.UserDAO;

public class Main {

    public static void main(String[] args) {
        ConnectionFactoryFactory.setType(ConnectionFactoryFactory.FactoryType.JDBC);
        UserDAO user = new UserDAOCJdbc();
        System.out.println(user.selectAll());
    }
}
