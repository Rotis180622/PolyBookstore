/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.controller;

import com.mycompany.projectone.entity.Promotion;

/**
 *
 * @author Gaudomun
 */
public interface PromotionController extends CRUDController<Promotion>{
    void filterByTimeRange();
}
