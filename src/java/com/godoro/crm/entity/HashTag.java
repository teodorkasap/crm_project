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
    
}
