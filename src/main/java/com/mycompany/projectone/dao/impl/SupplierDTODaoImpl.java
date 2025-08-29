/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.dao.impl;

import com.mycompany.projectone.dao.SupplierDTODao;
import com.mycompany.projectone.util.XQuery;
import com.mycompany.projectone.viewmodel.SupplierDTO;
import java.util.List;

/**
 *
 * @author Gaudomun
 */
public class SupplierDTODaoImpl implements SupplierDTODao {

    // SELECT JOIN: chỉ chọn các cột cần và alias khớp tên field trong DTO
    private final String baseSql = """
        SELECT 
            SUPPL.SupplierID   AS supplierID,
            SUPPL.SupplierName AS supplierName,
            SUPPL.NumberOfBooks AS numberOfBooks,
            SC.ContactID       AS contactID,
            SC.Email           AS email,
            SC.Phone           AS phone
        FROM Supplier SUPPL
        JOIN Supplier_Contacts SC
             ON SC.SupplierID = SUPPL.SupplierID
        """;

    private final String findAllSql = baseSql;

    private final String findBySupplierIdSql = baseSql + """
        WHERE SUPPL.SupplierID = ?
        """;

    private final String findByContactIdSql = baseSql + """
        WHERE SC.ContactID = ?
        """;

    private final String findBySupplierNameSql = baseSql + """
        WHERE SUPPL.SupplierName LIKE ?
        """;

    @Override
    public List<SupplierDTO> findAll() {
        return XQuery.getBeanList(SupplierDTO.class, findAllSql);
    }

    @Override
    public List<SupplierDTO> findBySupplierID(Integer supplierID) {
        return XQuery.getBeanList(SupplierDTO.class, findBySupplierIdSql, supplierID);
    }

    @Override
    public SupplierDTO findByContactID(Integer contactID) {
        return XQuery.getSingleBean(SupplierDTO.class, findByContactIdSql, contactID);
    }

    @Override
    public List<SupplierDTO> findBySupplierName(String keyword) {
        return XQuery.getBeanList(SupplierDTO.class, findBySupplierNameSql, "%" + keyword + "%");
    }

   
     
}
