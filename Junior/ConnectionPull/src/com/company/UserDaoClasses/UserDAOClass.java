package com.company.UserDaoClasses;

import com.company.ConnectionFactoryClasses.ConnectionFactoryFactory;
import com.company.UserClasses.User;
import com.company.interfaces.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykolai_Lytvyn on 02.02.2016.
 */
public class UserDAOClass implements UserDAO {

    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/JDBC";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Users";
    private static final String DELETE_BY_ID = "DELETE FROM Users WHERE id = ?";
    private Connection connection;

    {

        try {
            connection = ConnectionFactoryFactory.newConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //define one connection
    private Connection getConnection() {
        return connection;
    }

    @Override
    public List<User> selectAll() {
        //make connection
        Connection connect = getConnection();
        //The object used for executing a static SQL statement and returning the results it produces.
        Statement statement = null;
        //result execution PreparedStatement
        ResultSet rs = null;
        //collection of user
        List<User> users = new ArrayList<User>();
        try {
            //level isolation of transaction.There are four levels of isolation:
            // TRANSACTION_READ_UNCOMMITED
            // TRANSACTION_READ_COMMITTED
            // TRANSACTION__REPETABLE_READ
            // TRANSACTION_SERIALIZABLE
            connect.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            //if don't use this flag after every sql-query autocommit will be set
            connect.setAutoCommit(false);

            //using Statement. It include two study:
            //create
            //execute
            //
            //--------------------------------------
            //create and execute sql-query
            statement = connect.createStatement();
            rs = statement.executeQuery(SELECT_ALL_SQL);
            //--------------------------------------


            while (rs.next()) {
                //get data from sql-query
                int _id = rs.getInt("id");
                String login = rs.getString("login");
                String email = rs.getString("email");

                //set data to model
                User user = new User(_id);
                user.setEmail(login);
                user.setEmail(email);

                //save in collection
                users.add(user);
            }

            //commit for DB
            connect.commit();
            //if sql-query will be empty return empty collection

        } catch (SQLException ex) {
            System.out.println("hnya");

        }
        return users;

    }
}