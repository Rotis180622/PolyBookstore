/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;

import lombok.*;

/**
 *
 * @author Gaudomun
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PurchaseReceiptDetail {
    private int detailID;
    private PurchaseReceipt purchaseReceipt;
    private int bookID;
    private int quantity;
}
