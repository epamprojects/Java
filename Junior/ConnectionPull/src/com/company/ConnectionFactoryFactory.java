package com.company;

/**
 * Created by Mykolai_Lytvyn on 09.02.2016.
 */

/*
* abstract factory that retun abstract factory with connection
* */
public class ConnectionFactoryFactory {

    //enum with all class wich implement interface ConnectionFactory
    public static enum FactoryType {RAW, DBCP, JDBC}

    //set default value
    public static FactoryType curentType = FactoryType.RAW;

    public static void setType(FactoryType type) {
        curentType = type;
    }

    public static void newConnection() {
        ConnectionFactory result;

        switch (curentType) {
            case DBCP:
                result = new ConnectionFactoryDbcp();
                break;
            case JDBC:
                result = new ConnectionFactoryJDBC();
                break;
            case RAW:
                result = new ConnectionFactoryJDBC();
                break;
        }
    }

    ;


}
