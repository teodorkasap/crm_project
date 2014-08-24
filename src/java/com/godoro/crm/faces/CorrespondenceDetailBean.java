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
import com.godoro.crm.entity.HashTag;
import com.godoro.crm.repository.ContactRepository;
import com.godoro.crm.repository.CorrespondenceRepository;
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
public class CorrespondenceDetailBean {

    
    private Correspondence correspondence;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;
    private List<Employee> employeeList;
    private long selectedEmployeeId;
    private List<Customer> customerList;
    private long selectedCustomerId;
    private List<Contact> contactList;
    private long selectedContactId;
    
    
    
    /**
     * Creates a new instance of CorrespondenceDetailBean
     */
    public CorrespondenceDetailBean() {
        
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long correspondenceId = 0;
        if (request.getParameter("correspondenceId") != null) {
            correspondenceId = Long.parseLong(request.getParameter("correspondenceId"));
        }else{
            if (correspondenceId == 0) {
            correspondence = new Correspondence();

        } else {
            CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
            correspondence = correspondenceRepository.find(correspondenceId);
            correspondenceRepository.close();
        }
        }
        
            CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
            correspondence = correspondenceRepository.find(correspondenceId);
            correspondenceRepository.close();
        
        
    }
    public void save() {
    HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long correspondenceId = 0;

        if (request.getParameter("correspondenceId") != null) {
            correspondenceId = Long.parseLong(request.getParameter("correspondenceId"));
        }
        System.out.println("Secilen Okul kimligi " + selectedEmployeeId);
        if (selectedEmployeeId != 0) {

            EmployeeRepository employeeRepository = new EmployeeRepository();
            Employee employee = employeeRepository.find(selectedEmployeeId);
            employeeRepository.close();
            correspondence.setEmployee(employee);
        }
        System.out.println("Secilen Sinif kimligi " + selectedCustomerId);
        if (selectedCustomerId != 0) {

            CustomerRepository customerRepository = new CustomerRepository();
            Customer customer = customerRepository.find(selectedCustomerId);
            customerRepository.close();
            correspondence.setCustomer(customer);
        }
        System.out.println("Secilen Sinif kimligi " + selectedContactId);
        if (selectedContactId != 0) {

            ContactRepository contactRepository = new ContactRepository();
            Contact contact = contactRepository.find(selectedContactId);
            contactRepository.close();
            correspondence.setContact(contact);
        }
        CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
        if (correspondenceId == 0) {
            correspondenceRepository.persist(correspondence);
        } else {
            correspondenceRepository.merge(correspondence);
        }
        correspondenceRepository.close();
    }
    
}
    
