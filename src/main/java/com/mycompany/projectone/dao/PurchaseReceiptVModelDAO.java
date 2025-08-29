/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.viewmodel.PurchaseReceiptVM;
import java.sql.Date;
import java.util.List;



/**
 *
 * @author Gaudomun
 */
public interface PurchaseReceiptVModelDAO {
    List<PurchaseReceiptVM> findAll();
    List<PurchaseReceiptVM> findByEmpID(Integer employeeID);
    List<PurchaseReceiptVM> findBySupplID(Integer supplierID);
    List<PurchaseReceiptVM> findByReceiptID(Integer receiptID);
    PurchaseReceiptVM findByDetailID(Integer detailID);
    List<PurchaseReceiptVM> findByTimeRange(Date begin, Date end);
}
