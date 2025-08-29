/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.controller;

import com.mycompany.projectone.viewmodel.PurchaseReceiptVM;
import java.util.Date;

/**
 *
 * @author Gaudomun
 */
public interface PurchaseReceiptController extends CRUDController<PurchaseReceiptVM>{
    void saveForm();
    
    boolean validateInputForm();
    boolean validateForm();
    
    void filterByReceiptID(Integer receiptID);
    void filterByTimeRange(Date begin, Date end);
    
    void updateStock(Integer quantity, Date lastUpdated);
    void rollbackStock(Integer quantity);

}
