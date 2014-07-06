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
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId")
    private long eventId;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "eventName", length = 100, nullable = false)
    private String eventName;
    @Column(name = "eventTime")
    private double eventTime;
    @Column(name = "eventDate")
    private double eventDate;
    @Column(name = "eventNote", length = 600, nullable = true)
    private String eventNote;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public double getEventTime() {
        return eventTime;
    }

    public void setEventTime(double eventTime) {
        this.eventTime = eventTime;
    }

    public double getEventDate() {
        return eventDate;
    }

    public void setEventDate(double eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }
    
    
    

}
