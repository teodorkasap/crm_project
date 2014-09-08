/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Correspondence;
import com.godoro.library.database.BaseRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author erolerten
 */
public class CorrespondenceRepository extends BaseRepository<Correspondence>{
    private EntityManager entityManager;

    public CorrespondenceRepository (){
        super(Correspondence.class);
    }
    
    public List<Correspondence> listByCustomerId(long customerId){
        String string="select correspondence from Correspondence as correspondence "
                + " where correspondence.customer.customerId = :customerId";
        Query query=entityManager.createQuery(string);
        query.setParameter("customerId",customerId);
        return query.getResultList();
    }
    
    public List<Correspondence> listByHashTagId(long hashTagId){
        String string="select correspondence from Correspondence as correspondence "
                + " where correspondence.hashTag.hashTagId = :hashTagId";
        Query query=entityManager.createQuery(string);
        query.setParameter("hashTagId",hashTagId);
        return query.getResultList();
    }
    
    public List<Correspondence> listByEmployeeId(long employeeId){
        String string="select contact from Contact as contact "
                + " where contact.employee.employeeId = :employeeId";
        Query query=entityManager.createQuery(string);
        query.setParameter("employeeId",employeeId);
        return query.getResultList();
    }
    
    public List<Correspondence> listByContactId(long contactId){
        String string="select contact from Contact as contact "
                + " where contact.contact.contactId = :contactId";
        Query query=entityManager.createQuery(string);
        query.setParameter("contactId",contactId);
        return query.getResultList();
    }
    
    
    
    
}
