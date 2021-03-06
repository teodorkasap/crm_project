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
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author erolerten
 */
public class CustomerRepository extends BaseRepository<Customer>{
    

    public CustomerRepository(){
        super(Customer.class);
        
    }
    
    public List<Customer> listByEmployeeId(long employeeId){
        String string="select customer from Customer as customer "
                + " where customer.employee.employeeId = :employeeId";
        Query query=entityManager.createQuery(string);
        query.setParameter("employeeId",employeeId);
        return query.getResultList();
    }
    
    public List<Customer> listByHashTagId(long hashTagId){
        String string="select customer from Customer as customer "
                + " where customer.hashTag.hashTagId = :hashTagId";
        Query query=entityManager.createQuery(string);
        query.setParameter("hashTagId",hashTagId);
        return query.getResultList();
    }
    
    public List<Customer> listByProductId(long productId){
        String string="select customer from Customer as customer "
                + " where customer.product.productId = :productId";
        Query query=entityManager.createQuery(string);
        query.setParameter("productId",productId);
        return query.getResultList();
    }
    
    public List<Customer> listByContactId(long contactId){
        String string="select customer from Custoemr as customer "
                + " where customer.contact.contactId = :contactId";
        Query query=entityManager.createQuery(string);
        query.setParameter("contactId",contactId);
        return query.getResultList();
    }

    public Customer findByCustomerName (String customerName){
        try{
            String jpql=" select customer from Customer as customer" +
               " where customer.customerName = :customerName " ;
            Query query=entityManager.createQuery(jpql);
            query.setParameter("customerName", customerName);
            return (Customer) query.getSingleResult();
        }catch (NoResultException e){
           
           return null;
       }
    }
    
    

   public Customer findByCustomerNamePrefix(String customerNamePrefix){

       try{
     
           String jpql=" select customer from Customer as customer" +
               " where customer.customerName like :customerNamePattern " ;
           System.out.println(entityManager);
       Query query=entityManager.createQuery(jpql);
       query.setParameter("customerNamePattern",customerNamePrefix+"%");

     return (Customer) query.getSingleResult();
       }
       catch (NoResultException e){
           
           return null;
       }
           
       
       


   }

}

