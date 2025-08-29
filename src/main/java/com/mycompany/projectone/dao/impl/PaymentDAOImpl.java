/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.PaymentDAO;
import com.mycompany.projectone.entity.Payment;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class PaymentDAOImpl implements PaymentDAO {
    private final String createSql = "INSERT INTO Payments(PaymentId,Name,OderID) VALUES(?, ?, ?)";
    private final String updateSql = "UPDATE Payments SET Name=?, OderID=? WHERE PaymentId=?";
    private final String deleteByIdSql = "DELETE FROM Payments WHERE PaymentId=?";
    
    private final String findAllSql = "SELECT * FROM Payments";
    private final String findByIdSql = findAllSql + " WHERE PaymentId=?";



    @Override
    public Payment create(Payment payment) {
        String sql = "INSERT INTO Payments (PaymentsID, Name, OrderID) VALUES (?, ?, ?)";
        XJdbc.executeUpdate(sql,
                payment.getPaymentsID(),
                payment.getName(),
                payment.getOrderID());
        return payment;
    }

    @Override
    public void update(Payment payment) {
        String sql = "UPDATE Payments SET Name = ?, OrderID = ? WHERE PaymentsID = ?";
        XJdbc.executeUpdate(sql,
                payment.getName(),
                payment.getOrderID(),
                payment.getPaymentsID());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM Payments WHERE PaymentsID = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<Payment> findAll() {
      return XQuery.getBeanList(Payment.class, findAllSql);
    }

    @Override
    public Payment findById(Integer id) {
        return XQuery.getSingleBean(Payment.class, findByIdSql, id);
    }

}

