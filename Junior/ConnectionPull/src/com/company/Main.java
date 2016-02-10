package com.company;

import com.company.ConnectionFactoryClasses.ConnectionFactoryFactory;
import com.company.UserDaoClasses.UserDAOClass;
import com.company.interfaces.ConnectionFactory;
import com.company.interfaces.UserDAO;

public class Main {

    public static void main(String[] args) {
        ConnectionFactoryFactory.setType(ConnectionFactoryFactory.FactoryType.RAW);
        UserDAO user = new UserDAOClass();


    }
}
