package com.mycompany.projectone.dao.impl;


import com.mycompany.projectone.dao.CustomerDAO;
import com.mycompany.projectone.entity.Customer;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private String createSql = 
        "INSERT INTO Customers(CustomerID, FirstName, Age, EmailNum, Phone, Address, Gender) VALUES(?, ?, ?, ?, ?, ?, ?)";
    
    private String updateSql = 
        "UPDATE Customers SET FirstName=?, Age=?, EmailNum=?, Phone=?, Address=?, Gender=? WHERE CustomerID=?";
    
    private String deleteByIdSql = 
        "DELETE FROM Customers WHERE CustomerID=?";
    
    private String findAllSql = 
        "SELECT * FROM Customers";
    
    private String findByIdSql = 
        findAllSql + " WHERE CustomerID=?";

    @Override
    public Customer create(Customer entity) {
        Object[] values = {
            entity.getCustomerID(),
            entity.getFirstName(),
            entity.getAge(),
            entity.getEmailNum(),
            entity.getPhone(),
            entity.getAddress(),
            entity.isGender() // boolean -> BIT
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Customer entity) {
        Object[] values = {
            entity.getFirstName(),
            entity.getAge(),
            entity.getEmailNum(),
            entity.getPhone(),
            entity.getAddress(),
            entity.isGender(),
            entity.getCustomerID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Customer> findAll() {
        return XQuery.getBeanList(Customer.class, findAllSql);
    }

    @Override
    public Customer findById(Integer id) {
        return XQuery.getSingleBean(Customer.class, findByIdSql, id);
    }
}

