/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.BookDAO;
import com.mycompany.projectone.entity.Book;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class BookDAOImpl implements BookDAO {
    private final String createSql = 
        "INSERT INTO Books (BookID, Title, Author, PublisherYear, Price, CategoryID, SupplierID, QuantityInStock) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    private final String updateSql = 
        "UPDATE Books SET Title = ?, Author = ?, PublisherYear = ?, Price = ?, CategoryID = ?, SupplierID = ?, QuantityInStock = ? WHERE BookID = ?";
    
    private final String deleteByIdSql = 
        "DELETE FROM Books WHERE BookID = ?";
    
    private final String findByAuthorSql = 
        "SELECT b.BookID, b.Title, b.Author, b.PublisherYear, b.Price, cate.CategoryName, sp.SupplierName, s.Quantity " +
        "FROM Books b " +
        "JOIN Categories cate ON b.CategoryID = cate.CategoryID " +
        "JOIN Supplier sp ON b.SupplierID = sp.SupplierID " +
        "JOIN Stock s ON b.BookID = s.BookID " +
        "WHERE b.Author = ?";
    
    private final String findBySupplierSql = 
        "SELECT b.BookID, b.Title, b.Author, b.PublisherYear, b.Price, cate.CategoryName, sp.SupplierName, s.Quantity " +
        "FROM Books b " +
        "JOIN Categories cate ON b.CategoryID = cate.CategoryID " +
        "JOIN Supplier sp ON b.SupplierID = sp.SupplierID " +
        "JOIN Stock s ON b.BookID = s.BookID " +
        "WHERE sp.SupplierName = ?";
    
    private final String joinSql = """
                                    SELECT 
                                    b.BookID, b.Title, b.Author, b.PublisherYear, b.Price, cat.CategoryName, b.PublisherYear, b.QuantityInStock,
                                    sp.SupplierName, b.QuantityInStock
                                    FROM Books b
                                    JOIN Categories cat ON b.CategoryID = cat.CategoryID
                                    JOIN Supplier sp ON b.SupplierID = sp.SupplierID;
                                   """;
    private final String findAllSql = "SELECT * FROM Books";
    private final String findByIdSql = findAllSql + " WHERE BookID = ?";

    @Override
    public Book create(Book entity) {
        Object[] values = {
            entity.getBookID(),
            entity.getTitle(),
            entity.getAuthor(),
            entity.getPublisherYear(),
            entity.getPrice(),
            entity.getCategoryID(),
            entity.getSupplierID(),
            entity.getQuantityInStock()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Book entity) {
        Object[] values = {
            entity.getTitle(),
            entity.getAuthor(),
            entity.getPublisherYear(),
            entity.getPrice(),
            entity.getCategoryID(),
            entity.getSupplierID(),
            entity.getQuantityInStock(),
            entity.getBookID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Book> findAll() {
        return XQuery.getBeanList(Book.class, findAllSql);
    }
    
    public List<Book> findAllTables() {
        return XQuery.getBeanList(Book.class, joinSql);
    }
    

    @Override
    public Book findById(Integer id) {
        return XQuery.getSingleBean(Book.class, findByIdSql, id);
    }

    @Override
    public void updatePrice(Integer bookID, BigDecimal price) {
        String sql = "UPDATE Books SET Price = ? WHERE BookID = ?";
        XJdbc.executeUpdate(sql, price, bookID); // Đổi thứ tự tham số cho đúng
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return XQuery.getBeanList(Book.class, findByAuthorSql, author);
    }

    @Override
    public List<Book> findBySupplier(Integer supplierID) {
        return XQuery.getBeanList(Book.class, findBySupplierSql, supplierID);
    }
}



