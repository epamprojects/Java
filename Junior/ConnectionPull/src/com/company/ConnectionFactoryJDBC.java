package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Mykolai_Lytvyn on 08.02.2016.
 */
public class ConnectionFactoryJDBC implements ConnectionFactory {

    private static String JDBC_URL = "jdbc:mysql://127.0.0.1:6606";
    private static String LOGIN = "username";
    private static String PASSWORD = "password";

    @Override
    public Connection newConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
    }

    @Override
    public void close() throws SQLException {
        //nothing to close
    }
}
