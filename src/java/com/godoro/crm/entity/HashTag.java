/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author erolerten
 */
@Entity
@Table(name = "HashTag")
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashTagId")
    private long hashTagId;
    @Column(name = "hashTagContent", length = 100, nullable = false)
    private String hashTagContent; 
    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<Tag> tagList;
    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<Customer> customerList;
    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<Project> projectList;
    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<Product> productList;
    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<Correspondence> correspondenceList;
    
    
    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<Contact> contactList;

    
    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<Event> eventList;

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
    
    
    
    
    
    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    
    
    
    
    

    public long getHashTagId() {
        return hashTagId;
    }

    public void setHashTagId(long hashTagId) {
        this.hashTagId = hashTagId;
    }

    public String getHashTagContent() {
        return hashTagContent;
    }

    public void setHashTagContent(String hashTagContent) {
        this.hashTagContent = hashTagContent;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    

    

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    

    public List<Correspondence> getCorrespondenceList() {
        return correspondenceList;
    }

    public void setCorrespondenceList(List<Correspondence> correspondenceList) {
        this.correspondenceList = correspondenceList;
    }

    
    
    
    
}
