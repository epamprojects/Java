package com.company.ConnectionFactoryClasses;

import com.company.interfaces.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Mykolai_Lytvyn on 08.02.2016.
 */
public class ConnectionFactoryJDBC implements ConnectionFactory {

    private static String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/JDBC";
    private static String LOGIN = "root";
    private static String PASSWORD = "";
    private static String driverClass = "com.mysql.jdbc.Driver";
    @Override
    public Connection newConnection() throws SQLException {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("blyaa");
        }
        return DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
    }

    @Override
    public void close() throws SQLException {
        //nothing to close
    }
}
