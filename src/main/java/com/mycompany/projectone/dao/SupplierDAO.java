/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Supplier;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public interface SupplierDAO extends CrudDAO<Supplier, Integer> {
    List<Supplier> findByName(String keyword);
}
