package com.company;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Mykolai_Lytvyn on 08.02.2016.
 */
public interface ConnectionFactory {
    public Connection newConnection() throws SQLException;
    public void close()  throws SQLException;
}
