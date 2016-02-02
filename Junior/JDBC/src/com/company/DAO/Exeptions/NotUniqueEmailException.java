package com.company.DAO.Exeptions;

/**
 * Created by Mykolai_Lytvyn on 02.02.2016.
 */
public class NotUniqueEmailException extends DBSystemException {
    public NotUniqueEmailException(String messege) {
        super(messege);
    }
}
