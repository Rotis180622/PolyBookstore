/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.PurchaseReceiptDetail;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public interface PurchaseReceiptDetailDAO extends CrudDAO<PurchaseReceiptDetail, Integer> {
    List<PurchaseReceiptDetail> findByReceiptId(Integer receiptID);
}
