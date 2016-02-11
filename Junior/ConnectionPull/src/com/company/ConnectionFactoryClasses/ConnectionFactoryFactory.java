package com.company.ConnectionFactoryClasses;

import com.company.interfaces.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mykolai_Lytvyn on 09.02.2016.
 */

/*
* abstract factory that return abstract factory with connection
* */
public class ConnectionFactoryFactory {

    //enum with all class wich implement interface ConnectionFactory
    public static enum FactoryType {RAW, DBCP, JDBC}

    //set default value
    public static FactoryType curentType = FactoryType.RAW;

    public static ConnectionFactory setType(FactoryType type) {
        curentType = type;
        return null;
    }

    public static Connection newConnection() throws SQLException {
        Connection result = null;

        switch (curentType) {
            case DBCP:
                result = new ConnectionFactoryDbcp().newConnection();
                break;
            case JDBC:
                result = new ConnectionFactoryJDBC().newConnection();
                break;
            case RAW:
                result = new ConnectionFactoryJDBC().newConnection();
                break;
        }
        return result;
    };
}
