/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Contact;
import com.godoro.library.database.BaseRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author erolerten
 */
public class ContactRepository extends BaseRepository<Contact>{
    private EntityManager entityManager;
    public ContactRepository(){
        super(Contact.class);
    }
    
    public List<Contact> listByCustomerId(long customerId){
        String string="select contact from Contact as contact "
                + " where contact.customer.customerId = :customerId";
        Query query=entityManager.createQuery(string);
        query.setParameter("customerId",customerId);
        return query.getResultList();
    }
    
    public List<Contact> listByHashTagId(long hashTagId){
        String string="select contact from Contact as contact "
                + " where contact.hashTag.hashTagId = :hashTagId";
        Query query=entityManager.createQuery(string);
        query.setParameter("hashTagId",hashTagId);
        return query.getResultList();
    }
    
    public List<Contact> listByCorrespondenceId(long correspondenceId){
        String string="select contact from Contact as contact "
                + " where contact.correspondence.correspondenceId = :correspondenceId";
        Query query=entityManager.createQuery(string);
        query.setParameter("correspondenceId",correspondenceId);
        return query.getResultList();
    }
    
    public List<Contact> listByParticipantId(long participantId){
        String string="select contact from Contact as contact "
                + " where contact.participant.participantId = :participantId";
        Query query=entityManager.createQuery(string);
        query.setParameter("participantId",participantId);
        return query.getResultList();
    }
   
    
}
