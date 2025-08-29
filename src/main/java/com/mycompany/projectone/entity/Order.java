/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;


import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.mycompany.projectone.viewmodel.OrderDetailViewModel;


/**
 *
 * @author Administrator
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Order {
    private int orderID;
    private int customerID;
    private int employeeID;
    private Date orderDate;
    private int promotionID;
    private List<OrderDetail> orderDetails;
    private List<OrderDetailViewModel> viewModel;
}
