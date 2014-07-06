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
    @Column(name = "correspondenceName", length = 100, nullable = false)
    private String correspondenceName;
    @Column(name = "correspondenceTime")
    private double correspondenceTime;
    @Column(name = "correspondenceDate")
    private double correspondenceDate;
    @Column(name = "correspondenceNote", length = 10000, nullable = true)
    private String correspondenceNote;

}
