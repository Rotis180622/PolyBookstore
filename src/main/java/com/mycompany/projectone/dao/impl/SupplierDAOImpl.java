/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.SupplierDAO;
import com.mycompany.projectone.entity.Supplier;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class SupplierDAOImpl implements SupplierDAO {

    // Các câu SQL
    private final String createSql = 
        "INSERT INTO Supplier(SupplierID, SupplierName, NumberOfBooks) VALUES (?, ?, ?)";
    private final String updateSql = 
        "UPDATE Supplier SET SupplierName=?, NumberOfBooks=? WHERE SupplierID=?";
    private final String deleteByIdSql = 
        "DELETE FROM Supplier WHERE SupplierID=?";
    
    private final String findAllSql = 
        "SELECT * FROM Supplier";
    private final String findByIdSql = 
        findAllSql + " WHERE SupplierID=?"; 
    
     private final String findByNameSql = 
        findAllSql + " WHERE SupplierName LIKE ?";

    // Thêm Supplier
    @Override
    public Supplier create(Supplier entity) {
        Object[] values = {
            entity.getSupplierID(),
            entity.getSupplierName(),
            entity.getNumberOfBooks()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    // Cập nhật Supplier
    @Override
    public void update(Supplier entity) {
        Object[] values = {
            entity.getSupplierName(),
            entity.getNumberOfBooks(),
            entity.getSupplierID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    // Xóa theo ID
    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    // Lấy tất cả
    @Override
    public List<Supplier> findAll() {
        return XQuery.getBeanList(Supplier.class, findAllSql);
    }

    // Tìm theo ID
    @Override
    public Supplier findById(Integer id) {
        return XQuery.getSingleBean(Supplier.class, findByIdSql, id);
    }
    
     @Override
    public List<Supplier> findByName(String keyword) {
        return XQuery.getBeanList(Supplier.class, findByNameSql, "%" + keyword + "%");
    }
    
}
