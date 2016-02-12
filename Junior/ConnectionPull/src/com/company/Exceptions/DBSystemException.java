package com.company.Exceptions;

/**
 * Created by Mykolai_Lytvyn on 11.02.2016.
 */
public class DBSystemException extends Error {
    public DBSystemException(String s){

    }
    public DBSystemException(String s, String email) {
        super(s);
    }
}
