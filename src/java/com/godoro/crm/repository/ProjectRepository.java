/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Project;
import com.godoro.library.database.BaseRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author erolerten
 */
public class ProjectRepository extends BaseRepository<Project>{
    private EntityManager entityManager;
    public ProjectRepository (){
        super(Project.class);
    }
        
    public List<Project> listByCustomerId(long customerId){
        String string="select project from Project as project "
                + " where project.customer.customerId = :customerId";
        Query query=entityManager.createQuery(string);
        query.setParameter("customerId",customerId);
        return query.getResultList();
    }
    
    public List<Project> listByHashTagId(long hashTagId){
        String string="select project from Project as project "
                + " where project.hashTag.hashTagId = :hashTagId";
        Query query=entityManager.createQuery(string);
        query.setParameter("hashTagId",hashTagId);
        return query.getResultList();
    }
    
     public List<Project> listByEmployeeId(long employeeId){
        String string="select project from Project as project "
                + " where project.employee.employeeId = :employeeId";
        Query query=entityManager.createQuery(string);
        query.setParameter("employeeId",employeeId);
        return query.getResultList();
    }
     
     public List<Project> listByContactId(long contactId){
        String string="select project from Project as project "
                + " where project.contact.contactId = :contactId";
        Query query=entityManager.createQuery(string);
        query.setParameter("contactId",contactId);
        return query.getResultList();
    }
     
     public List<Project> listByEventId(long eventId){
        String string="select project from Project as project "
                + " where project.event.eventId= :eventId";
        Query query=entityManager.createQuery(string);
        query.setParameter("eventId",eventId);
        return query.getResultList();
    }
     
    
    
}
