/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.viewmodel.SupplierDTO;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public interface SupplierDTODao {
    List<SupplierDTO> findAll();
    List<SupplierDTO> findBySupplierID(Integer supplierID);
    SupplierDTO findByContactID(Integer contactID);
    List<SupplierDTO> findBySupplierName(String keyword);
}
