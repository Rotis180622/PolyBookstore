/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.viewmodel;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 *
 * @author Gaudomun
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class OrderDetailViewModel {
    private int orderID;
    private int detailedOrderID;

    private int bookID;         
    private String title;     

    private int categoryID;     
    private String categoryName;   
    
    private int employeeID;
    private int customerID;
    private int promotionID;
    
    private Date orderDate;

    private BigDecimal price;
    private int quantity;
    private BigDecimal discountValue;
    private BigDecimal total;
}

