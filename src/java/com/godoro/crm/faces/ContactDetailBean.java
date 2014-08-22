/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.HashTag;
import com.godoro.crm.entity.Project;
import com.godoro.crm.repository.ContactRepository;
import com.godoro.crm.repository.CustomerRepository;
import com.godoro.crm.repository.ProjectRepository;
import java.util.List;
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
    private List<HashTag> hashTagList;
    private long selectedHashTagId;
    private List<Customer> customerList;
    private long selectedCustomerId;
   

    

    
    

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public long getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedCustomerId(long selectedCustomerId) {
        this.selectedCustomerId = selectedCustomerId;
    }
    
    
    

    public List<HashTag> getHashTagList() {
        return hashTagList;
    }
    
    

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }

    public long getSelectedHashTagId() {
        return selectedHashTagId;
    }

    public void setSelectedHashTagId(long selectedHashTagId) {
        this.selectedHashTagId = selectedHashTagId;
    }
    
    

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
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long contactId = 0;

        if (request.getParameter("contactId") != null) {
            contactId = Long.parseLong(request.getParameter("contactId"));
        }
        System.out.println("Secilen Müşteri kimliği " + selectedCustomerId);
        if (selectedCustomerId != 0) {

            CustomerRepository customerRepository = new CustomerRepository();
            Customer customer = customerRepository.find(selectedCustomerId);
            customerRepository.close();
            contact.setCustomer(customer);
        }
        
        ContactRepository contactRepository = new ContactRepository();
        if (contactId == 0) {
            contactRepository.persist(contact);
        } else {
            contactRepository.merge(contact);
        }
        contactRepository.close();
    }
    
}