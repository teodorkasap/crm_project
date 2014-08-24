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
@Table(name = "Correspondence")
public class Correspondence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "correspondenceId")
    private long correspondenceId;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @JoinColumn(name = "projectId")
    private Project project;
    @Column(name = "correspondenceName", length = 100, nullable = false)
    private String correspondenceName;
    @Column(name = "correspondenceTime")
    private double correspondenceTime;
    @Column(name = "correspondenceDate")
    private double correspondenceDate;
    @Column(name = "correspondenceNote", length = 10000, nullable = true)
    private String correspondenceNote;
    @ManyToOne
    @JoinColumn(name = "contactId")
    private Contact contact;
    
    @OneToMany(mappedBy = "correspondence", cascade = CascadeType.ALL)
    private List<HashTag> hashTagList;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    
    
    public List<HashTag> getHashTagList() {
        return hashTagList;
    }

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }
    
    

    public long getCorrespondenceId() {
        return correspondenceId;
    }

    public void setCorrespondenceId(long correspondenceId) {
        this.correspondenceId = correspondenceId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getCorrespondenceName() {
        return correspondenceName;
    }

    public void setCorrespondenceName(String correspondenceName) {
        this.correspondenceName = correspondenceName;
    }

    public double getCorrespondenceTime() {
        return correspondenceTime;
    }

    public void setCorrespondenceTime(double correspondenceTime) {
        this.correspondenceTime = correspondenceTime;
    }

    public double getCorrespondenceDate() {
        return correspondenceDate;
    }

    public void setCorrespondenceDate(double correspondenceDate) {
        this.correspondenceDate = correspondenceDate;
    }

    public String getCorrespondenceNote() {
        return correspondenceNote;
    }

    public void setCorrespondenceNote(String correspondenceNote) {
        this.correspondenceNote = correspondenceNote;
    }

    
    
}
