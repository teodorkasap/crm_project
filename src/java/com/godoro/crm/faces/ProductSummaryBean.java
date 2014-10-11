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
public class ProductSummaryBean {
    
    private List<Product> productList;
    private List<Employee> employeeList;
    private long selectedEmployeeId;
    private List<Customer> customerList;
    private long selectedCustomerId;
    private List<Contact> contactList;
    private long selectedContactId;    
    private List<Project> projectList;
    private long selectedProjectId;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
    
    
    

    /**
     * Creates a new instance of ProductSummaryBean
     */
    public ProductSummaryBean() {
        
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeList = employeeRepository.list();
        employeeRepository.close();

        CustomerRepository customerRepository = new CustomerRepository();
        customerList = customerRepository.list();
        customerRepository.close();

        HashTagRepository hashTagRepository = new HashTagRepository();
        hashTagList = hashTagRepository.list();
        hashTagRepository.close();
        
        ProductRepository productRepository = new ProductRepository();
        productList = productRepository.list();
        productRepository.close();
        
        ProjectRepository projectRepository = new ProjectRepository();
        projectList = projectRepository.list();
        projectRepository.close();
    }
    
    public void filter() {
        System.out.println("Secilen Musteri kimligi " + selectedCustomerId);
        if (selectedCustomerId != 0) {
            ProductRepository productRepository = new ProductRepository();
            productList = productRepository.listByCustomerId(selectedCustomerId);
            productRepository.close();

        } else {
            if (selectedEmployeeId != 0) {
                ProductRepository productRepository = new ProductRepository();
                productList = productRepository.listByEmployeeId(selectedEmployeeId);
                productRepository.close();

            } else {

                if (selectedContactId != 0) {

                    ProductRepository productRepository = new ProductRepository();
                    productList = productRepository.listByContactId(selectedContactId);
                    productRepository.close();
                }  else {

                        if (selectedHashTagId != 0) {
                            ProductRepository productRepository = new ProductRepository();
                            productList = productRepository.listByHashTagId(selectedHashTagId);
                            productRepository.close();
                        } else {

                            ProductRepository productRepository = new ProductRepository();
                            productList = productRepository.list();
                            productRepository.close();
                        }
                    }
                
            }

        }

    }
    
    
}
