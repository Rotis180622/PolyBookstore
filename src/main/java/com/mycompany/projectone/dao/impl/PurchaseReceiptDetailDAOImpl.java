/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.PurchaseReceiptDetailDAO;
import com.mycompany.projectone.entity.PurchaseReceiptDetail;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class PurchaseReceiptDetailDAOImpl implements PurchaseReceiptDetailDAO {
     // SQL
    private final String createSql = 
        "INSERT INTO Purchase_Receipt_Details(ReceiptID, BookID, Quantity) VALUES (?, ?, ?)";
    private final String updateSql = 
        "UPDATE Purchase_Receipt_Details SET ReceiptID=?, BookID=?, Quantity=? WHERE DetailID=?";
    private final String deleteByIdSql = 
        "DELETE FROM Purchase_Receipt_Details WHERE DetailID=?";
    
    private final String findAllSql = 
        "SELECT * FROM Purchase_Receipt_Details";
    private final String findByIdSql = 
        findAllSql + " WHERE DetailID=?";
    private final String findByReceiptIdSql = 
        findAllSql + " WHERE ReceiptID=?";
    
    // CREATE
    @Override
    public PurchaseReceiptDetail create(PurchaseReceiptDetail entity) {
        Object[] values = {
            entity.getPurchaseReceipt().getReceiptID(),
            entity.getBookID(),
            entity.getQuantity()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    // UPDATE
    @Override
    public void update(PurchaseReceiptDetail entity) {
        Object[] values = {
            entity.getPurchaseReceipt().getReceiptID(),
            entity.getBookID(),
            entity.getQuantity(),
            entity.getDetailID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    // DELETE
    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    // FIND ALL
    @Override
    public List<PurchaseReceiptDetail> findAll() {
        return XQuery.getBeanList(PurchaseReceiptDetail.class, findAllSql);
    }

    // FIND BY ID
    @Override
    public PurchaseReceiptDetail findById(Integer id) {
        return XQuery.getSingleBean(PurchaseReceiptDetail.class, findByIdSql, id);
    }

    // FIND BY RECEIPT ID
    @Override
    public List<PurchaseReceiptDetail> findByReceiptId(Integer receiptId) {
        return XQuery.getBeanList(PurchaseReceiptDetail.class, findByReceiptIdSql, receiptId);
    }
}
