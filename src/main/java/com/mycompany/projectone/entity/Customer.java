/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

/**
 *
 * @author Administrator
 */
public class Customer {
    private int customerID;
    private String firstName;
    private int age;
    private String emailNum;
    private String phone;
    private String address;
    private boolean gender;
    
}
