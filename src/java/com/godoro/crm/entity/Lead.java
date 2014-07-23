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
import javax.persistence.Table;

/**
 *
 * @author erolerten
 */
@Entity
@Table(name = "Lead")
public class Lead {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leadId")
    private long leadId;
    @Column(name = "leadName", length = 100, nullable = false)
    private String leadName;
    @Column(name = "leadPhone", length = 50, nullable = false)
    private String leadPhone;
    @Column(name = "leadPhone2", length = 50, nullable = true)
    private String leadPhone2;
    @Column(name = "leadFax", length = 50, nullable = true)
    private String leadFax;
    @Column(name = "leadAddress", length = 300, nullable = true)
    private String leadAddress;
    @Column(name = "leadEmail", length = 100, nullable = true)
    private String leadEmail;
    @Column(name = "leadNotes", length = 500, nullable = true)
    private String leadNotes;

    public long getLeadId() {
        return leadId;
    }

    public void setLeadId(long leadId) {
        this.leadId = leadId;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getLeadPhone() {
        return leadPhone;
    }

    public void setLeadPhone(String leadPhone) {
        this.leadPhone = leadPhone;
    }

    public String getLeadPhone2() {
        return leadPhone2;
    }

    public void setLeadPhone2(String leadPhone2) {
        this.leadPhone2 = leadPhone2;
    }

    public String getLeadFax() {
        return leadFax;
    }

    public void setLeadFax(String leadFax) {
        this.leadFax = leadFax;
    }

    public String getLeadAddress() {
        return leadAddress;
    }

    public void setLeadAddress(String leadAddress) {
        this.leadAddress = leadAddress;
    }

    public String getLeadEmail() {
        return leadEmail;
    }

    public void setLeadEmail(String leadEmail) {
        this.leadEmail = leadEmail;
    }

    public String getLeadNotes() {
        return leadNotes;
    }

    public void setLeadNotes(String leadNotes) {
        this.leadNotes = leadNotes;
    }
    
    
    
    
}
