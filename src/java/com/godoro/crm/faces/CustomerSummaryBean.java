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
import com.godoro.crm.repository.HashTagRepository;
import com.godoro.crm.repository.ProductRepository;
import com.godoro.crm.repository.ProjectRepository;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class CustomerSummaryBean {
    
    private List<Customer> customerList;
    private List<Employee> employeeList;
    private long selectedEmployeeId;
    private List<Product> productList;
    private long selectedProductId;
    private List<Project> projectList;
    private long selectedProjectId;
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

    public long getSelectedHashTagId() {
        return selectedHashTagId;
    }

    public void setSelectedHashTagId(long selectedHashTagId) {
        this.selectedHashTagId = selectedHashTagId;
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

    public long getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(long selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
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

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public long getSelectedProjectId() {
        return selectedProjectId;
    }

    public void setSelectedProjectId(long selectedProjectId) {
        this.selectedProjectId = selectedProjectId;
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
    
    
    

    /**
     * Creates a new instance of CustomerSummaryBean
     */
    public CustomerSummaryBean() {
        
        CustomerRepository customerRepository = new CustomerRepository();
        customerList = customerRepository.list();
        customerRepository.close();

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeList = employeeRepository.list();
        employeeRepository.close();

        
        
        HashTagRepository hashTagRepository = new HashTagRepository();
        hashTagList = hashTagRepository.list();
        hashTagRepository.close();

        ContactRepository contactRepository = new ContactRepository();
        contactList = contactRepository.list();
        contactRepository.close();
        
        ProjectRepository projectRepository = new ProjectRepository();
        projectList = projectRepository.list();
        projectRepository.close();
        
        ProductRepository productRepository = new ProductRepository();
        productList = productRepository.list();
        productRepository.close();
        
        CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
        correspondenceList = correspondenceRepository.list();
        correspondenceRepository.close();
        
    }
    
    public void filter() {
        System.out.println("Secilen Calisan kimligi " + selectedEmployeeId);
        if (selectedEmployeeId != 0) {
            CustomerRepository customerRepository = new CustomerRepository();
            customerList = customerRepository.listByEmployeeId(selectedEmployeeId);
            customerRepository.close();

        } else {
            if (selectedHashTagId != 0) {
                CustomerRepository customerRepository = new CustomerRepository();
                customerList = customerRepository.listByHashTagId(selectedHashTagId);
                customerRepository.close();
            } else {
                if (selectedEmployeeId != 0) {
                    CustomerRepository customerRepository = new CustomerRepository();
                    customerList = customerRepository.listByEmployeeId(selectedEmployeeId);
                    customerRepository.close();

                } else {
                    if (selectedProductId != 0) {
                        CustomerRepository customerRepository = new CustomerRepository();
                        customerList = customerRepository.listByProductId(selectedProductId);
                        customerRepository.close();

                    } else {

                        if (selectedContactId != 0) {

                            CustomerRepository customerRepository = new CustomerRepository();
                            customerList = customerRepository.listByContactId(selectedProjectId);
                            customerRepository.close();
                        } else {

                            CustomerRepository customerRepository = new CustomerRepository();
                            customerList = customerRepository.list();
                            customerRepository.close();
                        }
                    }

                }
            }
        }

    }
    
    
}
