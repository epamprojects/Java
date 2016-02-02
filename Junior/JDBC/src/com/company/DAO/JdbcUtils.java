package com.company.DAO;

import java.sql.Connection;
import java.sql.SQLException;

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
}
