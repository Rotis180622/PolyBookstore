/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.PurchaseReceiptDAO;
import com.mycompany.projectone.entity.PurchaseReceipt;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class PurchaseReceiptDAOImpl implements PurchaseReceiptDAO {
    private final String createSql =
    "INSERT INTO Purchase_Receipts(ReceiptID, EmployeeID, ReceiptDate, SupplierID) VALUES (?, ?, ?, ?)";
    private final String updateSql =
        "UPDATE Purchase_Receipts SET EmployeeID=?, ReceiptDate=?, SupplierID=? WHERE ReceiptID=?";
    private final String deleteByIdSql =
        "DELETE FROM Purchase_Receipts WHERE ReceiptID=?";

    private final String findAllSql =
        "SELECT * FROM Purchase_Receipts";
    private final String findByIdSql =
        findAllSql + " WHERE ReceiptID=?";
    
    @Override
    public PurchaseReceipt create(PurchaseReceipt entity) {
        Object[] values = {
            entity.getReceiptID(),                       // vì ReceiptID không tự tăng
            entity.getEmployeeID(),        // lấy ID từ object
            entity.getReceiptDate(),
            entity.getSupplierID()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(PurchaseReceipt entity) {
        Object[] values = {
            entity.getEmployeeID(),
            entity.getReceiptDate(),
            entity.getSupplierID(),
            entity.getReceiptID()                        // WHERE điều kiện
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<PurchaseReceipt> findAll() {
        return XQuery.getBeanList(PurchaseReceipt.class, findAllSql);
    }

    @Override
    public PurchaseReceipt findById(Integer id) {
        return XQuery.getSingleBean(PurchaseReceipt.class, findByIdSql, id);
    }
}
