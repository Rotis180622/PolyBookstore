/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Book;
import com.mycompany.projectone.entity.Stock;

/**
 *
 * @author WellyOwO
 */
public interface StockDAO extends CrudDAO<Stock , Integer> {
    Stock findByBookID(Integer ID);
}
