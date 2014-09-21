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
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private long employeetId;
    @Column(name = "employeeName", length = 100, nullable = false)
    private String employeeName;
    @Column(name = "generatedSales")
    private double generatedSales;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Customer> customerList;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Event> eventList;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Product> productList;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Project> projectList;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Participant> participantList;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<User> userList;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Correspondence> correspondenceList;
    
    
    @ManyToOne @JoinColumn(name= "hashTagId")
    private HashTag hashTag;

    public HashTag getHashTag() {
        return hashTag;
    }

    public void setHashTag(HashTag hashTag) {
        this.hashTag = hashTag;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    



    
    
    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
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

    public long getEmployeetId() {
        return employeetId;
    }

    public void setEmployeetId(long employeetId) {
        this.employeetId = employeetId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getGeneratedSales() {
        return generatedSales;
    }

    public void setGeneratedSales(double generatedSales) {
        this.generatedSales = generatedSales;
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
    

}
