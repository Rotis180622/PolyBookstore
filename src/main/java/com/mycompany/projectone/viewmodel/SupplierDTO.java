/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.viewmodel;

import lombok.*;

/**
 *
 * @author Gaudomun
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class SupplierDTO {
    private int supplierID;
    private int contactID;
    private String supplierName;
    private int numberOfBooks;
    private String email;
    private String phone;
}
