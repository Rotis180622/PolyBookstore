/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.StockDAO;
import com.mycompany.projectone.entity.Book;
import com.mycompany.projectone.entity.Stock;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class StockDAOImpl implements StockDAO {

     private final String createSql = 
        "INSERT INTO Stock(StockID, BookID, Quantity, LastUpdated) VALUES(?, ?, ?, ?)";
    
    private final String updateSql = 
        "UPDATE Stock SET BookID=?, Quantity=?, LastUpdated=? WHERE StockID=?";
    
    private final String deleteByIdSql = 
        "DELETE FROM Stock WHERE StockID=?";
    
    private final String findAllSql = 
        "SELECT * FROM Stock";
    
    private final String findByIdSql = 
        findAllSql + " WHERE StockID=?";
    
    private final String findByBookIdSql = 
        findAllSql + " WHERE BookID=?";
    
    // CRUD methods
    @Override
    public Stock create(Stock entity) {
        Object[] values = {
            entity.getStockID(),
            entity.getBookID(),   // lấy ID từ Book
            entity.getQuantity(),
            entity.getLastUpdated()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }
    
    @Override
    public void update(Stock entity) {
        Object[] values = {
            entity.getBookID(),
            entity.getQuantity(),
            entity.getLastUpdated(),
            entity.getStockID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }
    
    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }
    
    @Override
    public List<Stock> findAll() {
        return XQuery.getBeanList(Stock.class, findAllSql);
    }
    
    @Override
    public Stock findById(Integer id) {
        return XQuery.getSingleBean(Stock.class, findByIdSql, id);
    }

    @Override
    public Stock findByBookID(Integer ID) {
        return XQuery.getSingleBean(Stock.class, findByBookIdSql, ID);
    }

 
    
}
