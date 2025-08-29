/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
 import java.math.BigDecimal;


/**
 *
 * @author WellyOwO
 */
public class Revenue {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
  
   

    public static class ByCategory {
        private int categoryID;
        private String categoryName;
        private BigDecimal revenue;
        private int quantity;
        private BigDecimal minPrice;
        private BigDecimal maxPrice;
        private BigDecimal avgPrice;
    }

     
     @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
     public static class ByEmp {
         private int employeeID;
         private String empName;
         private int numOfBills;
         private Date firstBill;
         private Date recentBill;
                 
     }
    
}
