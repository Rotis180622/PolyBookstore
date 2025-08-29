/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Order;
import java.util.List;
import java.util.Date;

/**
 *
 * @author WellyOwO
 */
public interface OrderDAO extends CrudDAO<Order, Integer> {
    List<Order> findByOrderDate(Date begin, Date end);
    boolean exists(Integer ID);
}
