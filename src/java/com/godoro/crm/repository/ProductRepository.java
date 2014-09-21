/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Product;
import com.godoro.library.database.BaseRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Erol
 */
public class ProductRepository extends BaseRepository<Product>{
    private EntityManager entityManager;
    public ProductRepository(){
        super(Product.class);
    }
    
    
    public List<Product> listByCustomerId(long customerId){
        String string="select product from Product as product "
                + " where product.customer.customerId = :customerId";
        Query query=entityManager.createQuery(string);
        query.setParameter("customerId",customerId);
        return query.getResultList();
    }
    
    public List<Product> listByEmployeeId(long employeeId){
        String string="select product from Product as product "
                + " where product.employee.employeeId = :employeeId";
        Query query=entityManager.createQuery(string);
        query.setParameter("employeeId",employeeId);
        return query.getResultList();
    }
    
    public List<Product> listByContactId(long contactId){
        String string="select product from Product as product "
                + " where product.contact.contactId = :contactId";
        Query query=entityManager.createQuery(string);
        query.setParameter("contactId",contactId);
        return query.getResultList();
    }
    
    public List<Product> listByHashTagId(long hashTagId){
        String string="select product from Product as product "
                + " where product.hashTag.hashTagId = :hashTagId";
        Query query=entityManager.createQuery(string);
        query.setParameter("hashTagId",hashTagId);
        return query.getResultList();
    }
}
