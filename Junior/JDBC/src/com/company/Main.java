package com.company;

import com.company.DAO.Exeptions.DBSystemException;
import com.company.DAO.UserDaoJdbc;

public class Main {

    public static void main(String[] args) throws DBSystemException {
        UserDaoJdbc user = new UserDaoJdbc();
        System.out.println(user.deleteById(2));
        System.out.println(user.selectAll());
    }
}
