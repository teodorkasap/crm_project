/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Correspondence;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.library.database.BaseRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author erolerten
 */
public class CustomerRepository extends BaseRepository<Customer>{
    
    private EntityManager entityManager;
    public CustomerRepository(){
        super(Customer.class);
    }
    
    public List<Customer> listByEmployeeId(long employeeId){
        String string="select contact from Contact as contact "
                + " where contact.employee.employeeId = :employeeId";
        Query query=entityManager.createQuery(string);
        query.setParameter("employeeId",employeeId);
        return query.getResultList();
    }
    
    public List<Customer> listByHashTagId(long hashTagId){
        String string="select contact from Contact as contact "
                + " where contact.hashTag.hashTagId = :hashTagId";
        Query query=entityManager.createQuery(string);
        query.setParameter("hashTagId",hashTagId);
        return query.getResultList();
    }
    
    public List<Customer> listByProductId(long productId){
        String string="select contact from Contact as contact "
                + " where contact.employee.employeeId = :employeeId";
        Query query=entityManager.createQuery(string);
        query.setParameter("employeeId",productId);
        return query.getResultList();
    }
    
    public List<Customer> listByContactId(long contactId){
        String string="select contact from Contact as contact "
                + " where contact.contact.contactId = :contactId";
        Query query=entityManager.createQuery(string);
        query.setParameter("contactId",contactId);
        return query.getResultList();
    }
    
}
