/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Correspondence;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.HashTag;
import com.godoro.library.database.BaseRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author erolerten
 */
public class HashTagRepository extends BaseRepository<HashTag>{
   
    public HashTagRepository(){
        super(HashTag.class);
    }
    
    public List<HashTag> listByCustomerId(long customerId){
        String string="select hashTag from HashTag as hashTag "
                + " where hashTag.customer.customerId = :customerId";
        Query query=entityManager.createQuery(string);
        query.setParameter("customerId",customerId);
        return query.getResultList();
    }
    
    public List<HashTag> listByEmployeeId(long employeeId){
        String string="select hashTag from HashTag as hashTag "
                + " where hashTag.employee.employeeId = :employeeId";
        Query query=entityManager.createQuery(string);
        query.setParameter("employeeId",employeeId);
        return query.getResultList();
    }
    
    public List<HashTag> listByContactId(long contactId){
        String string="select hashTag from HashTag as hashTag "
                + " where hashTag.contact.contactId = :contactId";
        Query query=entityManager.createQuery(string);
        query.setParameter("contactId",contactId);
        return query.getResultList();
    }
    
    public List<HashTag> listByCorrespondenceId(long correspondenceId){
        String string="select hashTag from HashTag as hashTag "
                + " where hashTag.correspondence.correspondenceId = :correspondenceId";
        Query query=entityManager.createQuery(string);
        query.setParameter("correspondenceId",correspondenceId);
        return query.getResultList();
    }
    
    public List<HashTag> listByEventId(long eventId){
        String string="select hashTag from HashTag as hashTag "
                + " where hashTag.event.eventId = :eventId";
        Query query=entityManager.createQuery(string);
        query.setParameter("eventId",eventId);
        return query.getResultList();
    }
    
    public HashTag findByHashTagName (String hashTagContent){
        try{
            String jpql=" select hashTag from HashTag as hashTag" +
               " where hashTag.hashTagContent = :hashTagContent " ;
            Query query=entityManager.createQuery(jpql);
            query.setParameter("hashTagContent", hashTagContent);
            return (HashTag) query.getSingleResult();
        }catch (NoResultException e){
           
           return null;
       }
    }
    
    

   public HashTag findByHashTagPrefix(String hashTagPrefix){

       try{
     
           String jpql=" select hashTag from HashTag as hashTag" +
               " where hashTag.hashTagContent like :hashTagContentPattern " ;
           System.out.println(entityManager);
       Query query=entityManager.createQuery(jpql);
       query.setParameter("hashTagContentPattern",hashTagPrefix+"%");

     return (HashTag) query.getSingleResult();
       }
       catch (NoResultException e){
           
           return null;
       }
           
       
       


   }
    
}
