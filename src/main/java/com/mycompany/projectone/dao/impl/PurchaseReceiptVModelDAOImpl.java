/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.PurchaseReceiptVModelDAO;
import com.mycompany.projectone.util.XQuery;
import com.mycompany.projectone.viewmodel.PurchaseReceiptVM;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class PurchaseReceiptVModelDAOImpl implements PurchaseReceiptVModelDAO {

    private final String baseSql = """
        SELECT 
                    PR.ReceiptID      AS receiptID,
                    PRD.DetailID      AS detailID,
                    PRD.BookID        AS bookID,
                    B.Title           AS title,
                    CAT.CategoryName    AS categoryName,
                    PRD.Quantity      AS quantity,
                    PR.EmployeeID     AS employeeID,
                    CONCAT(EMPL.Name, ' ', EMPL.FirstName) AS fullName,
                    PR.SupplierID     AS supplierID,
                    SUPPL.SupplierName AS supplierName,
                    PR.ReceiptDate    AS receiptDate
                FROM Purchase_Receipts PR
                JOIN Purchase_Receipt_Details PRD ON PRD.ReceiptID = PR.ReceiptID
                JOIN BOOKS B ON B.BookID = PRD.BookID
                JOIN CATEGORIES CAT ON CAT.CategoryID = B.CategoryID
                JOIN Supplier SUPPL ON SUPPL.SupplierID = PR.SupplierID
                JOIN Employees EMPL ON EMPL.EmployeeID = PR.EmployeeID
        """;

    private final String findAllSql = baseSql;

    private final String findByReceiptIdSql = baseSql + """
        WHERE PR.ReceiptID = ?
        """;

    private final String findByDetailIdSql = baseSql + """
        WHERE PRD.DetailID = ?
        """;

    private final String findBySupplierIdSql = baseSql + """
        WHERE SUPPL.SupplierID = ?
        """;

    private final String findByEmployeeIdSql = baseSql + """
        WHERE EMPL.EmployeeID = ?
        """;
    
    private final String findByTimeRangeSql = baseSql + """
        WHERE PR.ReceiptDate BETWEEN ? AND ?;
        """;

    @Override
    public List<PurchaseReceiptVM> findAll() {
        return XQuery.getBeanList(PurchaseReceiptVM.class, findAllSql);
    }

    @Override
    public List<PurchaseReceiptVM> findByReceiptID(Integer receiptID) {
        return XQuery.getBeanList(PurchaseReceiptVM.class, findByReceiptIdSql, receiptID);
    }

    @Override
    public PurchaseReceiptVM findByDetailID(Integer detailID) {
        return XQuery.getSingleBean(PurchaseReceiptVM.class, findByDetailIdSql, detailID);
    }

    @Override
    public List<PurchaseReceiptVM> findBySupplID(Integer supplierID) {
        return XQuery.getBeanList(PurchaseReceiptVM.class, findBySupplierIdSql, supplierID);
    }

    @Override
    public List<PurchaseReceiptVM> findByEmpID(Integer employeeID) {
        return XQuery.getBeanList(PurchaseReceiptVM.class, findByEmployeeIdSql, employeeID);
    }

    @Override
    public List<PurchaseReceiptVM> findByTimeRange(Date begin, Date end) {
        return XQuery.getBeanList(PurchaseReceiptVM.class, findByTimeRangeSql ,begin, end);
    }
    
}
