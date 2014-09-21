/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

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
public class EmployeeRepository extends BaseRepository<Employee>{
    
    private EntityManager entityManager;
    public EmployeeRepository(){
        super(Employee.class);
    }
    
    public List<Employee> listByCustomerId(long customerId){
        String string="select employee from Employee as employee "
                + " where employee.customer.customerId = :customerId";
        Query query=entityManager.createQuery(string);
        query.setParameter("customerId",customerId);
        return query.getResultList();
    }
    
    public List<Employee> listByHashTagId(long hashTagId){
        String string="select employee from Employee as employee "
                + " where employee.hashTag.hashTagId = :hashTagId";
        Query query=entityManager.createQuery(string);
        query.setParameter("hashTagId",hashTagId);
        return query.getResultList();
        
        
        
    }
    public List<Employee> listByProjectId(long projectId){
        String string="select employee from Employee as employee "
                + " where employee.project.projectId = :projectId";
        Query query=entityManager.createQuery(string);
        query.setParameter("projectId",projectId);
        return query.getResultList();
    }
    
    public List<Employee> listByProductId(long productId){
        String string="select employee from Employee as employee "
                + " where employee.product.productId = :productId";
        Query query=entityManager.createQuery(string);
        query.setParameter("productId",productId);
        return query.getResultList();
    }
    
}
