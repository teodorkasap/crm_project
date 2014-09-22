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
import com.godoro.crm.repository.ContactRepository;
import com.godoro.crm.repository.CorrespondenceRepository;
import com.godoro.crm.repository.CustomerRepository;
import com.godoro.crm.repository.EmployeeRepository;
import com.godoro.crm.repository.EventRepository;
import com.godoro.crm.repository.HashTagRepository;
import com.godoro.crm.repository.ProductRepository;
import com.godoro.crm.repository.ProjectRepository;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author erolerten
 */
@Named(value = "projectSummaryBean")
@RequestScoped
public class ProjectSummaryBean {

    private List<Project> projectList;
    private List<Customer> customerList;
    private long selectedCustomerId;
    private List<Employee> employeeList;
    private long selectedEmployeeId;
    private List<Contact> contactList;
    private long selectedContactId;
    private List<Event> eventList;
    private long selectedEventId;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;
    private List<Correspondence> correspondenceList;
    private long selectedCorrespondenceId;
    private List<Product> productList;
    private long selectedProductId;

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public long getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedCustomerId(long selectedCustomerId) {
        this.selectedCustomerId = selectedCustomerId;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public long getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(long selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public long getSelectedContactId() {
        return selectedContactId;
    }

    public void setSelectedContactId(long selectedContactId) {
        this.selectedContactId = selectedContactId;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public long getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(long selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public List<HashTag> getHashTagList() {
        return hashTagList;
    }

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }

    public long getSelectedHashTagListId() {
        return selectedHashTagId;
    }

    public void setSelectedHashTagListId(long selectedHashTagListId) {
        this.selectedHashTagId = selectedHashTagListId;
    }

    public List<Correspondence> getCorrespondenceList() {
        return correspondenceList;
    }

    public void setCorrespondenceList(List<Correspondence> correspondenceList) {
        this.correspondenceList = correspondenceList;
    }

    public long getSelectedCorrespondenceId() {
        return selectedCorrespondenceId;
    }

    public void setSelectedCorrespondenceId(long selectedCorrespondenceId) {
        this.selectedCorrespondenceId = selectedCorrespondenceId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public long getSelectedProductId() {
        return selectedProductId;
    }

    public void setSelectedProductId(long selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    /**
     * Creates a new instance of ProjectSummaryBean
     */
    public ProjectSummaryBean() {

        CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
        correspondenceList = correspondenceRepository.list();
        correspondenceRepository.close();

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeList = employeeRepository.list();
        employeeRepository.close();

        CustomerRepository customerRepository = new CustomerRepository();
        customerList = customerRepository.list();
        customerRepository.close();

        HashTagRepository hashTagRepository = new HashTagRepository();
        hashTagList = hashTagRepository.list();
        hashTagRepository.close();

        ContactRepository contactRepository = new ContactRepository();
        contactList = contactRepository.list();
        contactRepository.close();

        ProductRepository productRepository = new ProductRepository();
        productList = productRepository.list();
        productRepository.close();

        EventRepository eventRepository = new EventRepository();
        eventList = eventRepository.list();
        eventRepository.close();

    }

    public void filter() {
        System.out.println("Secilen Müşteri kimligi " + selectedCustomerId);
        if (selectedCustomerId != 0) {
            ProjectRepository projectRepository = new ProjectRepository();
            projectList = projectRepository.listByCustomerId(selectedCustomerId);
            projectRepository.close();

        } else {
            if (selectedHashTagId != 0) {
                ProjectRepository projectRepository = new ProjectRepository();
                projectList = projectRepository.listByHashTagId(selectedHashTagId);
                projectRepository.close();
            } else {
                if (selectedEmployeeId != 0) {
                    ProjectRepository projectRepository = new ProjectRepository();
                    projectList = projectRepository.listByEmployeeId(selectedEmployeeId);
                    projectRepository.close();

                } else {

                    if (selectedContactId != 0) {

                        ProjectRepository projectRepository = new ProjectRepository();
                        projectList = projectRepository.listByContactId(selectedContactId);
                        projectRepository.close();
                        
                        }else{
                        
                        if(selectedEventId != 0){
                            ProjectRepository projectRepository = new ProjectRepository();
                        projectList = projectRepository.listByEventId(selectedEventId);
                        projectRepository.close();
                            
                        

                    } else {

                        ProjectRepository projectRepository = new ProjectRepository();
                        projectList = projectRepository.list();
                        projectRepository.close();
                    }
                    
                }
                
                }

            }
        }

    }

}
