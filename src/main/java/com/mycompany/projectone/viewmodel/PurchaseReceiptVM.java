/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.viewmodel;

import lombok.*;
import com.mycompany.projectone.entity.Book;
import java.sql.Date;

/**
 *
 * @author Gaudomun
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PurchaseReceiptVM {
    private int receiptID;
    private int detailID;
    
    private int bookID;
    private String title;
    private int quantity;
    private String categoryName;
    
    private int employeeID;
    private String fullName;
    
    private int supplierID;
    private String supplierName;
    
    private Date receiptDate;
}
