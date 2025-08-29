/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.entity;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="Promotion")
/**
 *
 * @author Administrator
 */
public class Promotion {
    private int promotionID;
    private String promoTitle;
    private String description;
    private Date startDate;
    private Date endDate;
    
    @Column(name="Status")
    private boolean active;
    private BigDecimal discountValue;
    
}
