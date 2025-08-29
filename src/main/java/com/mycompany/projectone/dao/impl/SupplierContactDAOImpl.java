/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.SupplierContactDAO;
import com.mycompany.projectone.entity.SupplierContact;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class SupplierContactDAOImpl implements SupplierContactDAO{

    // SQL
    private final String createSql = 
        "INSERT INTO Supplier_Contacts(ContactID, Email, Phone, SupplierID) VALUES (?, ?, ?, ?)";
    private final String updateSql = 
        "UPDATE Supplier_Contacts SET Email=?, Phone=?, SupplierID=? WHERE ContactID=?";
    private final String deleteByIdSql = 
        "DELETE FROM Supplier_Contacts WHERE ContactID=?";
    
    private final String findAllSql = 
        "SELECT * FROM Supplier_Contacts";
    private final String findByIdSql = 
        findAllSql + " WHERE ContactID=?";
    private final String findBySupplierIdSql = 
        findAllSql + " WHERE SupplierID=?";

    // Thêm mới
    @Override
    public SupplierContact create(SupplierContact entity) {
        Object[] values = {
            entity.getContactID(),
            entity.getEmail(),
            entity.getPhone(),
            entity.getSupplier().getSupplierID() // FK
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    // Cập nhật
    @Override
    public void update(SupplierContact entity) {
        Object[] values = {
            entity.getEmail(),
            entity.getPhone(),
            entity.getSupplier().getSupplierID(),
            entity.getContactID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    // Xóa
    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    // Tìm tất cả
    @Override
    public List<SupplierContact> findAll() {
        return XQuery.getBeanList(SupplierContact.class, findAllSql);
    }

    // Tìm theo ContactID
    @Override
    public SupplierContact findById(Integer id) {
        return XQuery.getSingleBean(SupplierContact.class, findByIdSql, id);
    }

    // Tìm theo SupplierID (FK)
    @Override
    public List<SupplierContact> findBySupplierId(Integer supplierId) {
        return XQuery.getBeanList(SupplierContact.class, findBySupplierIdSql, supplierId);
    }
    
}
