/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Promotion;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public interface PromotionDAO extends CrudDAO<Promotion, Integer> {
    List<Promotion> findByTimeRange(Date end, Date begin);
}
