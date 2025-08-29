/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.SupplierContact;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public interface SupplierContactDAO extends CrudDAO<SupplierContact, Integer> {
    List<SupplierContact> findBySupplierId(Integer supplierId);
}
