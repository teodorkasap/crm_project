/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Event;
import com.godoro.crm.entity.Participant;
import com.godoro.crm.entity.Product;
import com.godoro.crm.entity.Project;
import com.godoro.crm.repository.CustomerRepository;
import com.godoro.crm.repository.EmployeeRepository;
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
    private List<Event> eventList;
    private List<Product> productList;
    private List<Project> projectList;
    

    /**
     * Creates a new instance of EmployeeDetailBean
     */
    public EmployeeDetailBean() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long employeeId = 0;
        if (request.getParameter("employeeId") != null) {
            employeeId = Long.parseLong(request.getParameter("employeeId"));
        }else{
            if (employeeId == 0) {
            employee = new Employee();

        } else {
            EmployeeRepository employeeRepository = new EmployeeRepository();
            employee = employeeRepository.find(employeeId);
            employeeRepository.close();
        }
        }
        
            EmployeeRepository employeeRepository = new EmployeeRepository();
            employee = employeeRepository.find(employeeId);
            employeeRepository.close();
    }
    
}
