/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.PromotionDAO;
import com.mycompany.projectone.entity.Promotion;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class PromotionDAOImpl implements PromotionDAO {

    private final String insertSql = """
        INSERT INTO Promotion(PromotionID, PromoTitle, Description, StartDate, EndDate, Status, DiscountValue)
        VALUES (?, ?, ?, ?, ?, ?, ?)
    """;

    private final String updateSql = """
        UPDATE Promotion
        SET PromoTitle = ?, Description = ?, StartDate = ?, EndDate = ?, Status = ?, DiscountValue = ?
        WHERE PromotionID = ?
    """;

    private final String deleteByIdSql = "DELETE FROM Promotion WHERE PromotionID = ?";

    private final String findAllSql = "SELECT * FROM Promotion";

    private final String findByIdSql = findAllSql + " WHERE PromotionID = ?";
    
    private final String findByTimeRangeSql = findAllSql + " WHERE StartDate <= ?  AND EndDate >= ?";

    @Override
    public Promotion create(Promotion entity) {
        Object[] args = {
            entity.getPromotionID(),
            entity.getPromoTitle(),
            entity.getDescription(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.isActive(),
            entity.getDiscountValue()
        };
        XJdbc.executeUpdate(insertSql, args);
        return entity;
    }

    @Override
    public void update(Promotion entity) {
        Object[] args = {
            entity.getPromoTitle(),
            entity.getDescription(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.isActive(),
            entity.getDiscountValue(),
            entity.getPromotionID()
        };
        XJdbc.executeUpdate(updateSql, args);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Promotion> findAll() {
        return XQuery.getBeanList(Promotion.class, findAllSql);
    }

    @Override
    public Promotion findById(Integer id) {
        return XQuery.getSingleBean(Promotion.class, findByIdSql, id);
    }

    @Override
    public List<Promotion> findByTimeRange(Date end, Date begin) {
        return XQuery.getBeanList(Promotion.class, findByTimeRangeSql, end, begin);
    }

}
