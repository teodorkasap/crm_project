/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Correspondence;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.HashTag;
import com.godoro.crm.entity.Participant;
import com.godoro.crm.repository.ContactRepository;
import com.godoro.crm.repository.CustomerRepository;
import com.godoro.crm.repository.HashTagRepository;
import com.sun.faces.util.CollectionsUtils;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class ContactDetailBean {
    
    private Contact contact;
    private List<HashTag> hashTagList;
    private String selectedHashTag;
    private List<Customer> customerList;
    private String selectedCustomerName;
    
    private List<Participant> participantList;
    private long selectedParticpantId;
    private List<Correspondence> correspondenceList;
    private long selectedCorrespondenceId;

    
{
    
}
    
    
    
    
          

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public String getSelectedCustomerName() {
        return selectedCustomerName;
    }

    public void setSelectedCustomerName(String selectedCustomerName) {
        this.selectedCustomerName = selectedCustomerName;
    }
    
    
    

    public List<HashTag> getHashTagList() {
        return hashTagList;
    }
    
    

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }

    public String getSelectedHashTag() {
        return selectedHashTag;
    }

    public void setSelectedHashTag(String selectedHashTag) {
        this.selectedHashTag = selectedHashTag;
    }
    
    

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public long getSelectedParticpantId() {
        return selectedParticpantId;
    }

    public void setSelectedParticpantId(long selectedParticpantId) {
        this.selectedParticpantId = selectedParticpantId;
    }

    public List<Correspondence> getCorrespondenceList() {
        return correspondenceList;
    }

    public void setCorrespondenceList(List<Correspondence> correspondenceList) {
        this.correspondenceList = correspondenceList;
    }

    public long getSelectedCorrespondenceId() {
        return selectedCorrespondenceId;
    }

    public void setSelectedCorrespondenceId(long selectedCorrespondenceId) {
        this.selectedCorrespondenceId = selectedCorrespondenceId;
    }
    
    

    /**
     * Creates a new instance of ContactDetailBean
     */
    public ContactDetailBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long contactId = 0;
        if (request.getParameter("contactId") != null) {
            contactId = Long.parseLong(request.getParameter("contactId"));
        }
        if (contactId == 0) {
            contact = new Contact();

        } else {
            ContactRepository contactRepository = new ContactRepository();
            contact = contactRepository.find(contactId);
            contactRepository.close();
        }

        CustomerRepository customerRepository = new CustomerRepository();
        customerList = customerRepository.list();
        customerRepository.close();
        
        HashTagRepository hashTagRepository = new HashTagRepository();
        hashTagList = hashTagRepository.list();
        hashTagRepository.close();              
        
    }
    
    public List<String> completeText(String customerNamePrefix) {
        System.out.println(customerNamePrefix);
        
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByCustomerNamePrefix(customerNamePrefix);
        customerRepository.close();
        
        List<String> results = new ArrayList<String>();  
        if (customer!=null){
        results.add(customer.getCustomerName());
        
       
        return results;
        }
        
        
        return null;
    }
    
    public List<String> completeTag(String hashTagPrefix) {
        System.out.println(hashTagPrefix);
        
        HashTagRepository hashTagRepository = new HashTagRepository();
        HashTag hashTag = hashTagRepository.findByHashTagPrefix(hashTagPrefix);
        
        
        List<String> results = new ArrayList<String>();  
        if (hashTag!=null){
        results.add(hashTag.getHashTagContent());
        

        return results;
        }
        
//      
//        HttpServletRequest request = (HttpServletRequest) FacesContext
//                .getCurrentInstance().getExternalContext().getRequest();
//        HashTagRepository hashtagRepository = new HashTagRepository();
//            hashtagRepository.persist(hashTag);
//        
//        hashtagRepository.close();
//    
//        System.out.println("yeni etiket eklendi");
        
        return null;
    }
    
    
    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long contactId = 0;

        if (request.getParameter("contactName") != null) {
            contactId = Long.parseLong(request.getParameter("contactName"));
        }
        System.out.println("Secilen Müşteri ismi: " + selectedCustomerName);
        if (selectedCustomerName != null) {
            CustomerRepository customerRepository = new CustomerRepository();
            Customer customer = customerRepository.findByCustomerName(selectedCustomerName);
            customerRepository.close();
            contact.setCustomer(customer);
        } else {
        }
        
        System.out.println("Secilen Etiketler: " + selectedHashTag);
        
        if (selectedHashTag != null) {

            HashTagRepository hashTagRepository = new HashTagRepository();
            HashTag hashTag = hashTagRepository.findByHashTagName(selectedHashTag);
            if (hashTag!=null){
                contact.setHashTag(hashTag);
            }else{
                hashTag = new HashTag();
                hashTag.setHashTagContent(selectedHashTag);
                hashTagRepository.persist(hashTag);
            }
            hashTagRepository.findByHashTagName(selectedHashTag);
            hashTagRepository.close();
            contact.setHashTag(hashTag);
        }
    
        System.out.println("yeni etiket eklendi");
        
        ContactRepository contactRepository = new ContactRepository();
        if (contactId == 0) {
            contactRepository.persist(contact);
        } else {
            contactRepository.merge(contact);
        }
        contactRepository.close();
    }
    
}
