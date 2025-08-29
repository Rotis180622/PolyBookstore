/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.OrderDetailViewDAO;
import com.mycompany.projectone.util.XQuery;
import com.mycompany.projectone.viewmodel.OrderDetailViewModel;
import java.util.Date;
import java.util.List;
import lombok.*;

/**
 *
 * @author Gaudomun
 */

        
public class OrderDetailViewDAOImpl implements OrderDetailViewDAO {
    private final String findAllSql = """
                                      SELECT 
                                        O.OrderID,                        -- orderID
                                        OD.DetailedOrderID,              -- detailedOrderID
                                        OD.BookID,                       -- bookID
                                        B.Title,                         -- title
                                        B.CategoryID,                    -- categoryID
                                        CAT.CategoryName,                -- categoryName
                                        O.EmployeeID,                    -- employeeID
                                        O.CustomerID,                    -- customerID
                                        O.PromotionID,                   -- promotionID
                                        O.OrderDate,                     -- orderDate
                                        B.Price,                         -- price
                                        OD.Quantity,                     -- quantity
                                        PRO.DiscountValue,              -- discountValue
                                        (B.Price * OD.Quantity * (1 - (ISNULL(PRO.DiscountValue, 0)/100))) AS Total -- total
                                      FROM Orders O
                                      JOIN Order_Details OD ON O.OrderID = OD.OrderID
                                      JOIN Books B ON OD.BookID = B.BookID
                                      JOIN Categories CAT ON B.CategoryID = CAT.CategoryID
                                      LEFT JOIN Promotion PRO ON O.PromotionID = PRO.PromotionID
                                                                            
                                      """;
    
    private final String findByIdSql = findAllSql + " WHERE O.OrderID=?;"; 
    private final String findByOrderDateSql = findAllSql + " WHERE O.OrderDate BETWEEN ? AND ?;";

    @Override
    public List<OrderDetailViewModel> findAll() {
        return XQuery.getBeanList(OrderDetailViewModel.class, findAllSql);
    }

    @Override
    public List<OrderDetailViewModel> findByID(Integer id) {
        return XQuery.getBeanList(OrderDetailViewModel.class, findByIdSql, id);
    }

    @Override
    public List<OrderDetailViewModel> findByOrderDate(Date begin, Date end) {
        return XQuery.getBeanList(OrderDetailViewModel.class, findByOrderDateSql, begin, end);
    }
    
}
