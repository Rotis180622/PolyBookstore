/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author Administrator
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderDetail {
    private int detailedOrderID;
    private int orderID;
    private int bookID;
    private int quantity;

    
}
