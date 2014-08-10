/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Correspondence;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Product;
import com.godoro.crm.entity.Project;
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
public class ProjectDetailBean {
    
    private Project project;
    private List<Product> productList;
    private List<Customer> customerList;
    private List<Employee> employeeList;
    private long selectedCustomerId;
    private long selectedEmployeeId;
    private long selectedProductId;
    private List<Correspondence> correspondenceList;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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

    public long getSelectedProductId() {
        return selectedProductId;
    }

    public void setSelectedProductId(long selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    public List<Correspondence> getCorrespondenceList() {
        return correspondenceList;
    }

    public void setCorrespondenceList(List<Correspondence> correspondenceList) {
        this.correspondenceList = correspondenceList;
    }
    
    

    /**
     * Creates a new instance of ProjectDetailBean
     */
    public ProjectDetailBean() {
        
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long projectId = 0;
        if (request.getParameter("projectId") != null) {
            projectId = Long.parseLong(request.getParameter("projectId"));
        }else{
            if (projectId == 0) {
            project = new Project();

        } else {
            ProjectRepository projectRepository = new ProjectRepository();
            project = projectRepository.find(projectId);
            projectRepository.close();
        }
        }
        
            ProjectRepository projectRepository = new ProjectRepository();
            project = projectRepository.find(projectId);
            projectRepository.close();
        
        
        
    }
    
}
