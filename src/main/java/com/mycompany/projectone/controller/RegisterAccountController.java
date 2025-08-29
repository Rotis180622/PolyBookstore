/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.controller;

import com.mycompany.projectone.entity.Account;
/**
 *
 * @author Gaudomun
 *
 * 
 */
public interface RegisterAccountController {
    Account getForm();
    
    boolean validateForm();
    
    void createDB();
    
    void clear();
}
