/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Event;
import com.godoro.crm.entity.HashTag;
import com.godoro.crm.entity.Participant;
import com.godoro.crm.entity.Product;
import com.godoro.crm.entity.Project;
import com.godoro.crm.entity.User;
import com.godoro.crm.repository.CustomerRepository;
import com.godoro.crm.repository.EmployeeRepository;
import com.godoro.crm.repository.HashTagRepository;
import com.godoro.crm.repository.UserRepository;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class EmployeeDetailBean {
    private Employee employee;
    private List<Customer> customerList;
    private long selectedCustomerId;
    private List<Event> eventList;
    private long selectedEventId;
    private List<Product> productList;
    private long selectedProductId;
    private List<Project> projectList;
    private long selectedProjectId;
    private List<User> userList;
    private long selectedUserId;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;
    

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public long getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedCustomerId(long selectedCustomerId) {
        this.selectedCustomerId = selectedCustomerId;
    }

    public long getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(long selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public long getSelectedProductId() {
        return selectedProductId;
    }

    public void setSelectedProductId(long selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    public long getSelectedProjectId() {
        return selectedProjectId;
    }

    public void setSelectedProjectId(long selectedProjectId) {
        this.selectedProjectId = selectedProjectId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public long getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
    
    

    /**
     * Creates a new instance of EmployeeDetailBean
     */
    public EmployeeDetailBean() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long employeeId = 0;
        if (request.getParameter("employeeId") != null) {
            employeeId = Long.parseLong(request.getParameter("employeeId"));
        }
        if (employeeId == 0) {
            employee = new Employee();

        } else {
            EmployeeRepository employeeRepository = new EmployeeRepository();
            employee = employeeRepository.find(employeeId);
            employeeRepository.close();
        }

        
        
        HashTagRepository hashtagRepository=new HashTagRepository();
        hashTagList=hashtagRepository.list();
        hashtagRepository.close();
    }
    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long employeeId = 0;

        if (request.getParameter("employeeId") != null) {
            employeeId = Long.parseLong(request.getParameter("employeeId"));
        }
        
        
        System.out.println("Secilen Etiketler " + selectedHashTagId);
        if (selectedHashTagId != 0) {

            HashTagRepository hashTagRepository = new HashTagRepository();
            HashTag hashTag = hashTagRepository.find(selectedHashTagId);
            hashTagRepository.close();
            employee.setHashTag(hashTag);
        }
        EmployeeRepository employeeRepository = new EmployeeRepository();
        if (employeeId == 0) {
            employeeRepository.persist(employee);
        } else {
            employeeRepository.merge(employee);
        }
        employeeRepository.close();
    }
    } 
        
    

