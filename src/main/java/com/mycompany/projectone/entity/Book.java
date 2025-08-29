/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;


import java.util.Locale.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
/**
 *
 * @author Administrator
 */
public class Book {
    private int bookID;
    private String title;
    private String author;
    private int publisherYear;  
    private BigDecimal price;
    private int categoryID;
    private int supplierID;
    private int quantityInStock;
}
