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
    @ManyToOne @JoinColumn(name= "customerId")
    private Customer customer;
    @ManyToOne @JoinColumn(name= "projectId")
    private Project project;
    @ManyToOne @JoinColumn(name= "productId")
    private Product product;
    @ManyToOne @JoinColumn(name= "correspondenceId")
    private Correspondence correspondence;
    @ManyToOne @JoinColumn(name= "eventId")
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Correspondence getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(Correspondence correspondence) {
        this.correspondence = correspondence;
    }
    
    
    
}
