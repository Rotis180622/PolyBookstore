/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Book;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public interface BookDAO extends CrudDAO<Book, Integer> {
    void updatePrice(Integer bookID, BigDecimal price);
    List<Book> findByAuthor(String author);
    List<Book> findBySupplier(Integer id);
}
