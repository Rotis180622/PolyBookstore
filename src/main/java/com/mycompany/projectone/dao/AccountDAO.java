/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Account;

/**
 *
 * @author WellyOwO
 */
public interface AccountDAO extends CrudDAO<Account, Integer> {
    Account findByEmpID(Integer id);
    void updatePass(Account entity);
}
