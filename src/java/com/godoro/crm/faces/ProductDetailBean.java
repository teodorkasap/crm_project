/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Product;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Erol
 */
@ManagedBean
@RequestScoped
public class ProductDetailBean {
    private Product product;
    private List<Customer> customerList;
    private List<Employee> employeeList;
    private long selectedCustomerId;
    private long selectedEmployeeId;
    

    /**
     * Creates a new instance of ProductDetailBean
     */
    public ProductDetailBean() {
        
        
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public long getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedCustomerId(long selectedCustomerId) {
        this.selectedCustomerId = selectedCustomerId;
    }

    public long getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(long selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }
    
}
