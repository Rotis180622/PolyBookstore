/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import java.util.List;
import java.util.Date;

/**
 *
 * @author Gaudomun
 * @param <T>
 * @param <ID>
 */
public interface ReadOnlyDAO<T, ID> {
    List<T> findAll();
    
    List<T> findByID(ID id);
    
    List<T> findByOrderDate(Date begin, Date end);
}
