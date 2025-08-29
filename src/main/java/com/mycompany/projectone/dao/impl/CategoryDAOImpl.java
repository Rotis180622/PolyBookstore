/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.CategoryDAO;
import com.mycompany.projectone.dao.CrudDAO;
import com.mycompany.projectone.entity.Categories;
import com.mycompany.projectone.util.XJdbc;
import com.mycompany.projectone.util.XQuery;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class CategoryDAOImpl implements CategoryDAO {

    private final String createSql = "INSERT INTO Categories(CategoryID, CategoryName) VALUES(?, ?)";
    private final String updateSql = "UPDATE Categories SET CategoryName=? WHERE CategoryID=?";
    private final String deleteByIdSql = "DELETE FROM Categories WHERE CategoryID=?";

    private final String findAllSql = "SELECT * FROM Categories";
    private final String findByIdSql = findAllSql + " WHERE CategoryID=?";

    @Override
    public Categories create(Categories entity) {
        Object[] values = {
            entity.getCategoryID(),
            entity.getCategoryName()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Categories entity) {
        Object[] values = {
            entity.getCategoryName(),
            entity.getCategoryID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Categories> findAll() {
        return XQuery.getBeanList(Categories.class, findAllSql);
    }

    @Override
    public Categories findById(Integer id) {
        return XQuery.getSingleBean(Categories.class, findByIdSql, id);
    }
}


