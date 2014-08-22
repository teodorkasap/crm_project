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
import com.godoro.crm.entity.HashTag;
import com.godoro.crm.entity.Product;
import com.godoro.crm.entity.Project;
import com.godoro.crm.repository.CustomerRepository;
import com.godoro.crm.repository.EmployeeRepository;
import com.godoro.crm.repository.ProjectRepository;
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
    private long selectedEmployeeId;
    private List<Project> projectList;
    private long selectedProjectId;
    private List<Product> productList;
    private long selectedProductId;
    private List<Event> eventList;
    private long selectedEventId;
    private List<Correspondence> correspondenceList;
    private long selectedCorrespondenceId;
    private List<Contact> contactList;
    private long selectedContactId;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;

    public List<HashTag> getHashTagList() {
        return hashTagList;
    }

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }
    
    

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

    public long getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(long selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public long getSelectedprojectId() {
        return selectedprojectId;
    }

    public void setSelectedprojectId(long selectedprojectId) {
        this.selectedprojectId = selectedprojectId;
    }

    public long getSelectedProductId() {
        return selectedProductId;
    }

    public void setSelectedProductId(long selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    public long getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(long selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public long getSelectedCorrespondenceId() {
        return selectedCorrespondenceId;
    }

    public void setSelectedCorrespondenceId(long selectedCorrespondenceId) {
        this.selectedCorrespondenceId = selectedCorrespondenceId;
    }

    public long getSelectedContactId() {
        return selectedContactId;
    }

    public void setSelectedContactId(long selectedContactId) {
        this.selectedContactId = selectedContactId;
    }

    public long getSelectedHashTagId() {
        return selectedHashTagId;
    }

    public void setSelectedHashTagId(long selectedHashTagId) {
        this.selectedHashTagId = selectedHashTagId;
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
    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long customerId = 0;

        if (request.getParameter("customerId") != null) {
            customerId = Long.parseLong(request.getParameter("customerId"));
        }
        System.out.println("Secilen Çalışan kimligi " + selectedEmployeeId);
        if (selectedEmployeeId != 0) {

            EmployeeRepository employeeRepository = new EmployeeRepository();
            Employee employee = employeeRepository.find(selectedEmployeeId);
            employeeRepository.close();
            customer.setEmployee(employee);
        }
        System.out.println("Secilen Proje kimligi " + selectedProjectId);
        if (selectedProjectId != 0) {

            ProjectRepository projectRepository = new ProjectRepository();
            Project project = projectRepository.find(selectedProjectId);
            projectRepository.close();
            customer.setProject(project);
        }
        CustomerRepository customerRepository = new CustomerRepository();
        if (customerId == 0) {
            customerRepository.persist(customer);
        } else {
            customerRepository.merge(customer);
        }
        customerRepository.close();
    }
    
}
