/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.AccountDAO;
import com.mycompany.projectone.entity.Account;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class AccountDAOImpl implements AccountDAO{
    private final String createSql = "INSERT INTO Accounts(AccountID, Username, Password, status, EmployeeID, Role) VALUES(?, ?, ?, ?, ?,?)";
    private final String updateSql = "UPDATE Accounts SET Username=?, status=?, EmployeeID=?, Role=? WHERE AccountID=?";
    private final String updatePassSql = "UPDATE Accounts SET Password=? WHERE AccountID=?";
    private final String deleteByIdSql = "DELETE FROM Accounts WHERE AccountID=?";
    
    private final String findAllSql = "SELECT * FROM Accounts";
    private final String findByIdSql = findAllSql + " WHERE AccountID=?"; 
    private final String findByEmpIdSql = findAllSql + " WHERE EmployeeID=?";
    
    @Override
    public Account create(Account entity) {
        Object[] values = {
        entity.getAccountID(),
        entity.getUsername(),
        entity.getPassword(),
        entity.isActive(),
        entity.getEmployeeID()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

  @Override
    public void update(Account entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getPassword(),
            entity.isActive(),        // status đúng vị trí
            entity.getEmployeeID(),
            entity.getAccountID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }
    
    @Override
    public void updatePass(Account entity) {
        Object[] values = {
            entity.getPassword(),
            entity.getAccountID()
        };
        XJdbc.executeUpdate(updatePassSql, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }
//
    @Override
    public List<Account> findAll() {
        return XQuery.getBeanList(Account.class, findAllSql);
    }

    @Override
    public Account findById(Integer id) {
        return XQuery.getSingleBean(Account.class, findByIdSql, id);
    }


    @Override
    public Account findByEmpID(Integer id) {
        return XQuery.getSingleBean(Account.class, findByEmpIdSql, id);
    }
    
}
