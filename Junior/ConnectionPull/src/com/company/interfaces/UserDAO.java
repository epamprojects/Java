package com.company.interfaces;

import com.company.UserClasses.User;

import java.util.List;

/**
 * Created by Mykolai_Lytvyn on 10.02.2016.
 */
public interface UserDAO {
    public List<User> selectAll();
}
