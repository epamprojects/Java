package com.company.ConnectionFactoryClasses;

import com.company.interfaces.ConnectionFactory;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mykolai_Lytvyn on 09.02.2016.
 */
public class ConnectionFactoryDbcp implements ConnectionFactory {
    private static String JDBC_URL = "jdbc:mysql://127.0.0.1:6606";
    private static String LOGIN = "username";
    private static String PASSWORD = "password";
    private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private final  BasicDataSource dataSource;

    public ConnectionFactoryDbcp(){
        BasicDataSource ds = new BasicDataSource();
        // setting for BasicDataSource
        ds.setDriverClassName(DRIVER_CLASS);
        ds.setUrl(JDBC_URL);
        ds.setJmxName(LOGIN);
        ds.setPassword(PASSWORD);
        dataSource = ds;
    };

    public Connection newConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void close() throws SQLException {
        dataSource.close();
    }
}
