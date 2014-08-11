/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.repository.ContactRepository;
import com.godoro.crm.repository.EmployeeRepository;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class ContactDetailBean {
    
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    

    /**
     * Creates a new instance of ContactDetailBean
     */
    public ContactDetailBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long contactId = 0;
        if (request.getParameter("contactId") != null) {
            contactId = Long.parseLong(request.getParameter("contactId"));
        }else{
            if (contactId == 0) {
            contact = new Contact();

        } else {
            ContactRepository contactRepository = new ContactRepository();
            contact = contactRepository.find(contactId);
            contactRepository.close();
        }
        }
        
            ContactRepository contactRepository = new ContactRepository();
            contact = contactRepository.find(contactId);
            contactRepository.close();
        
    }
    
}
