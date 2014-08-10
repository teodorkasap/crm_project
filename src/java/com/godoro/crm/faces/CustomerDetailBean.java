/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Correspondence;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Event;
import com.godoro.crm.entity.Product;
import com.godoro.crm.entity.Project;
import com.godoro.crm.repository.CustomerRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class CustomerDetailBean {
    
    private Customer customer;
    private List<Employee> employeeList;
    private List<Project> projectList;
    private List<Product> productList;
    private List<Event> eventList;
    private List<Correspondence> correspondenceList;
    private List<Contact> contactList;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Correspondence> getCorrespondenceList() {
        return correspondenceList;
    }

    public void setCorrespondenceList(List<Correspondence> correspondenceList) {
        this.correspondenceList = correspondenceList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
            
          
    
    

    /**
     * Creates a new instance of CustomerDetailBean
     */
    public CustomerDetailBean() {
        
         HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long customerId = 0;
        if (request.getParameter("customerId") != null) {
            customerId = Long.parseLong(request.getParameter("customerId"));
        }else{
            if (customerId == 0) {
            customer = new Customer();

        } else {
            CustomerRepository customerRepository = new CustomerRepository();
            customer = customerRepository.find(customerId);
            customerRepository.close();
        }
        }
        
            CustomerRepository customerRepository = new CustomerRepository();
            customer = customerRepository.find(customerId);
            customerRepository.close();
        
    }
    
}
