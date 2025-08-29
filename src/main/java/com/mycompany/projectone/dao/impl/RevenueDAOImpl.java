/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.RevenueDAO;
import com.mycompany.projectone.entity.Revenue;
import com.mycompany.projectone.util.XQuery;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class RevenueDAOImpl implements RevenueDAO{
    public static String revenueByCategorySql = "SELECT " 
    + "CAT.CategoryID, " 
    + "CAT.CategoryName, " 
    + "SUM(OD.Quantity * B.Price) AS [Revenue], "
    + "SUM(OD.Quantity) AS [Quantity], "
    + "MIN(B.Price) AS [MinPrice], "
    + "MAX(B.Price) AS [MaxPrice], "
    + "AVG(B.Price) AS [AvgPrice] "
    + "FROM Books B "
    + "JOIN Categories CAT ON B.CategoryID = CAT.CategoryID "
    + "JOIN Order_Details OD ON B.BookID = OD.BookID "
    + "JOIN Orders O ON OD.OrderID = O.OrderID "
    + "WHERE o.OrderDate IS NOT NULL " 
    + "AND O.OrderDate BETWEEN ? AND ? "
    + "GROUP BY CAT.CategoryID, CAT.CategoryName "
    + "ORDER BY [Revenue] DESC;" ;
    
    public static String revenueByEmpSql = 
            """
            SELECT 
                           EMP.EmployeeID, 
                           CONCAT(EMP.FirstName,' ', EMP.Name) AS [EmpName], 
                           COUNT(*) AS [NumOfBills], 
                           MIN(O.OrderDate) AS [FirstBill], 
                           MAX(O.OrderDate) AS [RecentBill]
                           FROM Employees EMP
                           JOIN Orders O ON EMP.EmployeeID = O.EmployeeID
                           WHERE O.OrderDate IS NOT NULL 
                           AND O.OrderDate BETWEEN ? AND ?
                           GROUP BY EMP.EmployeeID, EMP.FirstName, EMP.Name
                           ORDER BY [NumOfBills] DESC
                                           
            """;


    @Override
    public List<Revenue.ByCategory> revenueByCategory(Date begin, Date end) {
        return XQuery.getBeanList(Revenue.ByCategory.class, revenueByCategorySql, begin, end);
    }

    @Override
    public List<Revenue.ByEmp> revenueByEmp(Date begin, Date end) {
        return XQuery.getBeanList(Revenue.ByEmp.class, revenueByEmpSql, begin, end);
    }
    
}
