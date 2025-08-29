/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.EmployeeDAO;
import com.mycompany.projectone.entity.Employee;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    private String createSql = "INSERT INTO Employees(EmployeeID, Name, FirstName, Age, Email, PhoneNum, Address, Role, Gender) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String updateSql = "UPDATE Employees SET Name=?, FirstName=?, Age=?, Email=?, PhoneNum=?, Address=?, Role=?, Gender=? WHERE EmployeeID=?";
    private String deleteByIdSql = "DELETE FROM Employees WHERE EmployeeID=?";
    
    private String findAllSql = "SELECT * FROM Employees";
    private String findByIdSql = findAllSql + " WHERE EmployeeID=?";

    @Override
    public Employee create(Employee entity) {
        Object[] values = {
            entity.getEmployeeID(),
            entity.getName(),
            entity.getFirstName(),
            entity.getAge(),
            entity.getEmail(),
            entity.getPhoneNum(),
            entity.getAddress(),
            entity.isRole(),
            entity.isGender()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Employee entity) {
         Object[] values = {
            entity.getName(),
            entity.getFirstName(),
            entity.getAge(),
            entity.getEmail(),
            entity.getPhoneNum(),
            entity.getAddress(),
            entity.isRole(),
            entity.isGender(),
            entity.getEmployeeID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer id) {
         XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Employee> findAll() {
        return XQuery.getBeanList(Employee.class, findAllSql);

    }

    @Override
    public Employee findById(Integer id) {
        return XQuery.getSingleBean(Employee.class, findByIdSql, id);
    }
}
