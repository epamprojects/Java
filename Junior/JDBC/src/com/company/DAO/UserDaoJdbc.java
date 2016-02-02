package com.company.DAO;

import com.company.DAO.Exeptions.DBSystemException;
import com.company.DAO.Exeptions.NotUniqueUserLoginException;
import sun.jdbc.odbc.JdbcOdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykolai_Lytvyn on 02.02.2016.
 */
public class UserDaoJdbc implements UserDAO {

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "root";
    private static final String JDBC_URL = "JDBC_URL";
    private static final String SELECT_ALL_SQL = "SELECT * FROM User";

    //define one connection
    private Connection getConnection() throws  DBSystemException {
        try {
            return DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
        } catch (SQLException ex) {
            throw new DBSystemException("Ca't create connection", ex);
        }
    };

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public List<User> deleteById(int id) throws DBSystemException{
        //make connection
        Connection connect = getConnection();
        //An object that represents a precompiled SQL statement.
        PreparedStatement ps = null;
        //The object used for executing a static SQL statement and returning the results it produces.
        Statement statement = null;
        //result execution PreparedStatement
        ResultSet rs = null;
        //collection of user
        List<User> users = new ArrayList<User>();
        try{
            //level isolation of transaction.There are four levels of isolation:
                // TRANSACTION_READ_UNCOMMITED
                // TRANSACTION_READ_COMMITTED
                // TRANSACTION__REPETABLE_READ
                // TRANSACTION_SERIALIZABLE
            connect.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            //if don't use this flag after every sql-query autocommit will be set
            connect.setAutoCommit(false);

            //create and execute sql-query
            statement = connect.createStatement();
            rs = statement.executeQuery(SELECT_ALL_SQL);

            while (rs.next()){
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
            return  users;
        } catch (SQLException ex){
            JdbcUtils.rollbackQuetly(connect);
            throw new DBSystemException("Can't execute SQL query = ", SELECT_ALL_SQL);
        }
    }

     @Override
    public void insert(User users) throws DBSystemException, NotUniqueUserLoginException {

    }
}
