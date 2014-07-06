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
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private long customertId;
    @Column(name = "customerName", length = 100, nullable = false)
    private String customerName;
    @Column(name = "generatedRevenue")
    private double generatedRevenue;
    @ManyToOne @JoinColumn(name= "employeeId")
    private Employee employee;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Product> productList;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Event> eventList;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Correspondence> correspondenceList;
    @Column(name = "corporate", nullable = false)
    private boolean corporateClient;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contact> contactList;

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    
    
    public boolean isCorporateClient() {
        return corporateClient;
    }

    public void setCorporateClient(boolean corporateClient) {
        this.corporateClient = corporateClient;
    }
    
    
    

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Correspondence> getCorrespondenceList() {
        return correspondenceList;
    }

    public void setCorrespondenceList(List<Correspondence> correspondenceList) {
        this.correspondenceList = correspondenceList;
    }
   

    public long getCustomertId() {
        return customertId;
    }

    public void setCustomertId(long customertId) {
        this.customertId = customertId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getGeneratedRevenue() {
        return generatedRevenue;
    }

    public void setGeneratedRevenue(double generatedRevenue) {
        this.generatedRevenue = generatedRevenue;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
