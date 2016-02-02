package com.company.DAO;

/**
 * Created by Mykolai_Lytvyn on 01.02.2016.
 */
public class User {
    private final int  id;
    private String login;
    private String email;

    public User(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
