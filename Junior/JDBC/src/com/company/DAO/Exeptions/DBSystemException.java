package com.company.DAO.Exeptions;

import java.sql.SQLException;

/**
 * Created by Mykolai_Lytvyn on 01.02.2016.
 */
public class DBSystemException extends Exception {
    public DBSystemException(String messege) {
    }
    public DBSystemException(String message, String ex){
        super(message);
    }

    public DBSystemException(String message, SQLException ex) {

    }
}
