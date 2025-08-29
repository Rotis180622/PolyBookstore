/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.controller;

import com.mycompany.projectone.entity.Book;

/**
 *
 * @author WellyOwO
 */
public interface BookController extends CRUDController<Book> {
    void findByAuthor();
    void findBySupplierID();
    void findByID();
}
