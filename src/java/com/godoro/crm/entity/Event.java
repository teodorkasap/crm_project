/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.crm.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author erolerten
 */
@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId")
    private long eventId;
    
    
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<HashTag> hashTagList;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Participant> participantList;

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }
    
    
    
    public List<HashTag> getHashTagList() {
        return hashTagList;
    }

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }

    public Date getDateTimeField() {
        return dateTimeField;
    }

    public void setDateTimeField(Date dateTimeField) {
        this.dateTimeField = dateTimeField;
    }
    

    
    
    @Column(name = "eventName", length = 100, nullable = false)
    private String eventName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATETIME_FIELD")
    private java.util.Date dateTimeField; 
    @Column(name = "eventNote", length = 600, nullable = true)
    private String eventNote;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

   

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
    

}
