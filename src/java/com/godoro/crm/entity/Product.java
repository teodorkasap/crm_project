/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author erol
 */
@Entity
@Table(name = "Product")
public class Product {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private long productId;
    @ManyToOne @JoinColumn(name= "employeeId")
    private Employee employee;
    @ManyToOne @JoinColumn(name= "customerId")
    private Customer customer;
    @Column(name = "productName", length = 100, nullable = false)
    private String productName;
    @Column(name = "salesPrice")
    private double salesPrice;

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
    
    

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }
    
    
    
    
}
