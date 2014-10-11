/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class EmployeeSummaryBean {
    
    private List<Employee> employeeList;
    private List<Customer> customerList;
    private long selectedCustomerId;
    private List<Product> productList;
    private long selectedProductId;
    private List<Project> projectList;
    private long selectedProjectId;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;
    private List<Contact> contactList;
    private long selectedContactId;

    public List<HashTag> getHashTagList() {
        return hashTagList;
    }

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }
    
    

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
    
    

    /**
     * Creates a new instance of EmployeeSummaryBean
     */
    public EmployeeSummaryBean() {
        
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
        
        
        
        
        
    }
    
    public void filter() {
        System.out.println("Secilen Musteri kimligi " + selectedCustomerId);
        if (selectedCustomerId != 0) {
            EmployeeRepository employeeRepository = new EmployeeRepository();
            employeeList = employeeRepository.listByCustomerId(selectedCustomerId);
            employeeRepository.close();

        } else {
            if (selectedHashTagId != 0) {
                EmployeeRepository employeeRepository = new EmployeeRepository();
                employeeList = employeeRepository.listByHashTagId(selectedHashTagId);
                employeeRepository.close();
            } else {
                if (selectedProjectId != 0) {
                    EmployeeRepository employeeRepository = new EmployeeRepository();
                    employeeList = employeeRepository.listByProjectId(selectedProjectId);
                    employeeRepository.close();

                } else {
                    if (selectedProductId != 0) {
                        EmployeeRepository employeeRepository = new EmployeeRepository();
                        employeeList = employeeRepository.listByProductId(selectedProductId);
                        employeeRepository.close();

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
