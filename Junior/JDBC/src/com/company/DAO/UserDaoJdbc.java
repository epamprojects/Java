package com.company.DAO;

import com.company.DAO.Exeptions.DBSystemException;
import com.company.DAO.Exeptions.NotUniqueUserLoginException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykolai_Lytvyn on 02.02.2016.
 */
public class UserDaoJdbc implements UserDAO {

    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/JDBC";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Users";
    private static final String DELETE_BY_ID = "DELETE FROM Users WHERE id = ?";

    static{
        JdbcUtils.initDriver();
    }
    //define one connection
    private Connection getConnection() throws  DBSystemException {
        try {
            return DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
        } catch (SQLException ex) {
            throw new DBSystemException("Ca'nt create connection", ex);
        }
    }

    @Override
    public List<User> selectAll() throws DBSystemException {
        //make connection
        Connection connect = getConnection();
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

            //using Statement. It include two study:
                //create
                //execute
            //
            //--------------------------------------
            //create and execute sql-query
            statement = connect.createStatement();
            rs = statement.executeQuery(SELECT_ALL_SQL);
            //--------------------------------------


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
        }finally {
            JdbcUtils.closeQuetly(rs);
            JdbcUtils.closeQuetly(statement);
            JdbcUtils.closeQuetly(connect);
        }
    }

    @Override
    public int deleteById(int id) throws DBSystemException{
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

            // Prepeare statement have meaning when query using a not once
            //using PrepeareStatement. It include thre study:
            //prepeare statement, where include query with empty param, which define as "?"
            //execute updata
            //
            //--------------------------------------
            ps = connect.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);
            int result = ps.executeUpdate();

            //commit for DB
            connect.commit();
            //if sql-query will be empty return empty collection
            return  result;
        } catch (SQLException ex){
            JdbcUtils.rollbackQuetly(connect);
            throw new DBSystemException("Can't execute SQL query = ", SELECT_ALL_SQL);
        }finally {
            JdbcUtils.closeQuetly(rs);
            JdbcUtils.closeQuetly(statement);
            JdbcUtils.closeQuetly(connect);
        }
    }

    @Override
    public void insert(User users) throws DBSystemException, NotUniqueUserLoginException {

    }
}
