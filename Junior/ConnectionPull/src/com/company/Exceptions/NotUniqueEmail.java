package com.company.Exceptions;

/**
 * Created by Mykolai_Lytvyn on 11.02.2016.
 */
public class NotUniqueEmail extends DBSystemException {
    public NotUniqueEmail(String s, String email) {
        super(s,email);
    }
}
