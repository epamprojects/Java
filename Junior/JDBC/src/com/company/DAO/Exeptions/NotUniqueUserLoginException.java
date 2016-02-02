package com.company.DAO.Exeptions;

/**
 * Created by Mykolai_Lytvyn on 01.02.2016.
 */
public class NotUniqueUserLoginException extends DBSystemException {

    public NotUniqueUserLoginException(String messege) {
        super(messege);
    }
}
