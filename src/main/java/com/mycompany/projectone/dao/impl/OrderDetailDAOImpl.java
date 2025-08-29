/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.OrderDetailDAO;
import com.mycompany.projectone.entity.OrderDetail;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class OrderDetailDAOImpl implements OrderDetailDAO {
    private final String createSql = "INSERT INTO Order_Details(BookID, OrderID, Quantity) VALUES(?, ?, ?)";
    private final String updateSql = "UPDATE Order_Details SET BookID=?, OrderID=?, Quantity=? WHERE DetailedOrderID=?";
    private final String deleteSql = "DELETE FROM Order_Details WHERE DetailedOrderID=?";
    private final String findAllSql = "SELECT * FROM Order_Details";
    private final String findByIdSql = findAllSql + "WHERE DetailedOrderID=? ";

    @Override
    public OrderDetail create(OrderDetail entity) {
        Object[] data = {
            entity.getBookID(),
            entity.getOrderID(),
            entity.getQuantity()
        };
        XJdbc.executeUpdate(createSql, data);
        return entity;
    }

    @Override
    public void update(OrderDetail entity) {
        Object[] data = {
            entity.getBookID(),
            entity.getOrderID(),
            entity.getQuantity(),
            entity.getDetailedOrderID()
        };
        XJdbc.executeUpdate(updateSql, data);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<OrderDetail> findAll() {
        return XQuery.getBeanList(OrderDetail.class, findAllSql);
    }

    @Override
    public OrderDetail findById(Integer id) {
        return XQuery.getSingleBean(OrderDetail.class, findByIdSql, id);
    }
    
}
