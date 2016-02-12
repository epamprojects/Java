package com.company.Exceptions;

/**
 * Created by Mykolai_Lytvyn on 11.02.2016.
 */
public class NotUniqueLogin extends DBSystemException {
    public NotUniqueLogin(String err, String messege) {
        super(err, messege);
    }
}
