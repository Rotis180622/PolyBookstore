/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.OrderDAO;
import com.mycompany.projectone.entity.Order;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaudomun
 */
public class OrderDAOImpl implements OrderDAO{
    
    private final String createSql = "INSERT INTO Orders(OrderID, CustomerID, EmployeeID, OrderDate, PromotionID) VALUES(?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Orders SET CustomerID=?, EmployeeID=?, OrderDate=?, PromotionID=? WHERE OrderID=?";
    private final String deleteSql = "DELETE FROM Orders WHERE OrderID=?";
    
    
    private final String findAllSql = "SELECT * FROM Orders";
    private final String findByIdSql = findAllSql + " WHERE OrderID=?"; 
    private final String findByOrderDateSql = findAllSql + " WHERE OrderDate=?";

    @Override
    public Order create(Order entity) {
        Object[] values = {
            entity.getOrderID(),
            entity.getCustomerID(),
            entity.getEmployeeID(),
            entity.getOrderDate(),
            entity.getPromotionID()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Order entity) {
        Object[] values = {
            entity.getCustomerID(),
            entity.getEmployeeID(),
            entity.getOrderDate(),
            entity.getPromotionID(),
            entity.getOrderID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Order> findAll() {
        return XQuery.getBeanList(Order.class, findAllSql);
    }

    @Override
    public Order findById(Integer id) {
        return XQuery.getSingleBean(Order.class, findByIdSql, id);
    }

    @Override
    public List<Order> findByOrderDate(Date begin, Date end) {
        return XQuery.getBeanList(Order.class, findByOrderDateSql, begin, end);
    }

    @Override
    public boolean exists(Integer ID) {
        ResultSet rs = null;
        try {
            String checkSql = "  SELECT TOP 1 1 FROM Orders WHERE OrderID = ?;";
            rs = XJdbc.executeQuery(checkSql, ID);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try{
                if(rs != null) rs.getStatement().getConnection().close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    
}
