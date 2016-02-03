package com.company.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mykolai_Lytvyn on 02.02.2016.
 */
public class JdbcUtils {
    public static void rollbackQuetly(Connection connect) {
        if(connect != null){
            try{
                connect.rollback();
            }catch(SQLException e){
                // there are my be logs
            }
        }
    }

    public static void closeQuetly(Connection connect){

    }

    public static void closeQuetly(Statement statement) {
    }

    public static void closeQuetly(ResultSet rs) {
    }
}
