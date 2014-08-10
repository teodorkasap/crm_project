/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Product;
import com.godoro.crm.entity.Project;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class ProjectDetailBean {
    
    private Project project;
    private List<Product> productList;
    private List<Customer> customerList;
    private List<Employee> employeeList;
    private long selectedCustomerId;
    private long selectedEmployeeId;
    private long selectedProductId;
    
    

    /**
     * Creates a new instance of ProjectDetailBean
     */
    public ProjectDetailBean() {
        
        
        
    }
    
}
