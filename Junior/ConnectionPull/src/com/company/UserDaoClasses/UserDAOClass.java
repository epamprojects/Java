package com.company.UserDaoClasses;

import com.company.ConnectionFactoryClasses.ConnectionFactoryFactory;
import com.company.Exceptions.DBSystemException;
import com.company.Exceptions.NotUniqueEmail;
import com.company.Exceptions.NotUniqueLogin;
import com.company.UserClasses.User;
import com.company.interfaces.ConnectionFactory;
import com.company.interfaces.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykolai_Lytvyn on 02.02.2016.
 */
public class UserDAOClass implements UserDAO {
    private static final String SELECT_ALL_SQL = "SELECT * FROM Users";
    private static final String SELECT_BY_LOGIN = "SELECT * FROM Users WHERE Login = ?";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM Users WHERE Email = ?";

    private static final String INSERT_SQL = "INSERT INTO Users" + "(Id, Email, Login) VALUES" + "(?,?,?)";
    private Connection connection;


    private boolean existWithLogin0(Connection connection, String login) throws NotUniqueLogin, SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_BY_LOGIN);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    };

    private boolean existWithEmail0(Connection connection, String email) throws NotUniqueEmail, SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_BY_EMAIL);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    };

    //define connection provider for DAO
    public void setConnection(ConnectionFactoryFactory.FactoryType factoryType) {
        {
            try {
                ConnectionFactoryFactory.setType(factoryType);
                connection = ConnectionFactoryFactory.newConnection();
            } catch (SQLException e) {
                System.out.println("problem with sql");
                e.printStackTrace();
            }
        }
    }

    ;

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

    @Override
    public boolean insert(User user) throws NotUniqueLogin, NotUniqueEmail, SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = null;

        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false );
            if (existWithLogin0(connection, user.getLogin())) {
                throw new NotUniqueLogin("Not unique login: ", user.getLogin());
            }

            if (existWithEmail0(connection, user.getEmail())) {
                throw new NotUniqueEmail("Not unique login: ", user.getEmail());
            }

            ps = connection.prepareStatement(INSERT_SQL);

            ps.setInt(1, 10);
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
            connection.commit();
            connection.close();
        } catch (DBSystemException ex) {
            System.out.println( ex + "not added");
        };

        return false;
    };
}