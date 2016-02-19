package com.company;

import com.sun.rowset.WebRowSetImpl;

import javax.sql.rowset.WebRowSet;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.SQLException;

public class Main {
    private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/JDBC";
    private static String LOGIN = "root";
    private static String PASSWORD = "";
    private static String SET_COMMAND = "select * from users";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        {
            Class.forName(DRIVER_CLASS);
        }

        WebRowSet webRowSet_0 = new WebRowSetImpl();
        getAllUsers(webRowSet_0);
        System.out.println(toXML(webRowSet_0));
    }


    static void getAllUsers(WebRowSet webRowSet) throws SQLException {
        webRowSet.setCommand("select * from users");
        webRowSet.setUrl(JDBC_URL);
        webRowSet.setUsername(LOGIN);
        webRowSet.setPassword(PASSWORD);
        //must be execute!!
        webRowSet.execute();
    }

    static WebRowSet fromXMl(String string) throws SQLException {
        WebRowSet webRowSet = new WebRowSetImpl();
        webRowSet.readXml(new StringReader(string));
        return  webRowSet;
    }

    static String toXML(WebRowSet webRowSet) throws SQLException {
        StringWriter writer = new StringWriter();
        webRowSet.writeXml(writer);
        return writer.toString();

    }

}
