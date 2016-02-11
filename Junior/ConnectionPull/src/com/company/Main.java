package com.company;

import com.company.ConnectionFactoryClasses.ConnectionFactoryFactory;
import com.company.UserDaoClasses.UserDAOClass;

public class Main {

    public static void main(String[] args) {
        UserDAOClass user = new UserDAOClass();
        user.setConnection(ConnectionFactoryFactory.FactoryType.JDBC);
        System.out.println(user.selectAll());
    }
}
