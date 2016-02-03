package com.company;

import com.company.DAO.UserDaoJdbc;

public class Main {

    public static void main(String[] args) {
        UserDaoJdbc user = new UserDaoJdbc();
        System.out.println(user.selectAll());
        System.out.println("start");
    }
}
