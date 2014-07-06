/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author erolerten
 */

@Entity
@Table(name = "Contact")
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactId")
    private long contactId;
    @Column(name = "contactName", length = 100, nullable = false)
    private String contactName;
    @Column(name = "contactAddress", length = 500, nullable = false)
    private String contactAddress;
    @Column(name = "contactTel", length = 100, nullable = false)
    private String contactTel;
    
    
    @ManyToOne @JoinColumn(name= "customerId")
    private Customer customer;

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
}
