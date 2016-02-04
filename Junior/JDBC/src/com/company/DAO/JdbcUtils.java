package com.company.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mykolai_Lytvyn on 02.02.2016.
 */
public class JdbcUtils {

    private static String driverClass = "com.mysql.jdbc.Driver";
    /*
    *  registration concret driver for work with db.
    *  (This driver is required to work with MySql. If will need change db, required change argument on "com.microsoft.sqlserver.jdbc.SQLServerDriver")
    * */
    public static void initDriver() {
        try {
            // registration class through reflection. After registaration it will be avilable for DriverManager
            // and DriverManager define needed class by input jdbc url
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //work with transaction
    public static void rollbackQuetly(Connection connect) {
        if (connect != null) {
            try {
                connect.rollback();
            } catch (SQLException e) {
                // there are my be logs
            }
        }
    }

    //work with transaction
    public static void closeQuetly(Connection connect){

    }

    //work with transaction
    public static void closeQuetly(Statement statement) {
    }

    //work with transaction
    public static void closeQuetly(ResultSet rs) {
    }
}
