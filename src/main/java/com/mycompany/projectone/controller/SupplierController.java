/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.controller;

import com.mycompany.projectone.viewmodel.SupplierDTO;

/**
 *
 * @author Gaudomun
 */
public interface SupplierController extends CRUDController<SupplierDTO>  {
    void findBySupplierName(String supplierName);
    void findBySupplierID(Integer supplierID);
    void findByContactID(Integer contactID);
    
    void saveForm();
    
    boolean validateForm();
    boolean validateInputForm();
}
