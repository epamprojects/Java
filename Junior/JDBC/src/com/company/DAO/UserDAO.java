package com.company.DAO;

import com.company.DAO.Exeptions.DBSystemException;
import com.company.DAO.Exeptions.NotUniqueEmailException;
import com.company.DAO.Exeptions.NotUniqueUserLoginException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mykolai_Lytvyn on 01.02.2016.
 */
public interface UserDAO {
    public List<User> selectAll() throws DBSystemException;
    public List<User> deleteById(int id) throws SQLException, DBSystemException;
    public void insert(User users) throws DBSystemException, NotUniqueUserLoginException, NotUniqueEmailException;
}
