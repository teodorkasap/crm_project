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
import com.godoro.crm.repository.HashTagRepository;
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

    public Correspondence getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(Correspondence correspondence) {
        this.correspondence = correspondence;
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
     * Creates a new instance of CorrespondenceDetailBean
     */
    public CorrespondenceDetailBean() {
        
        
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long correspondenceId = 0;
        if (request.getParameter("correspondenceId") != null) {
            correspondenceId = Long.parseLong(request.getParameter("correspondenceId"));
        }
        if (correspondenceId == 0) {
            correspondence = new Correspondence();

        } else {
            CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
            correspondence = correspondenceRepository.find(correspondenceId);
            correspondenceRepository.close();
        }

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeList = employeeRepository.list();
        employeeRepository.close();
        
        ContactRepository contactRepository=new ContactRepository();
        contactList=contactRepository.list();
        contactRepository.close();
        
        CustomerRepository customerRepository=new CustomerRepository();
        customerList=customerRepository.list();
        customerRepository.close();
        
        HashTagRepository hashTagRepository = new HashTagRepository();
        hashTagList = hashTagRepository.list();
        hashTagRepository.close();
        
        
    }
    public void save() {
    HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long correspondenceId = 0;

        if (request.getParameter("correspondenceId") != null) {
            correspondenceId = Long.parseLong(request.getParameter("correspondenceId"));
        }
        System.out.println("Secilen Müşteri Temsilcisi kimligi " + selectedEmployeeId);
        if (selectedEmployeeId != 0) {

            EmployeeRepository employeeRepository = new EmployeeRepository();
            Employee employee = employeeRepository.find(selectedEmployeeId);
            employeeRepository.close();
            correspondence.setEmployee(employee);
        }
        System.out.println("Seçilen Müşteri kimligi " + selectedCustomerId);
        if (selectedCustomerId != 0) {

            CustomerRepository customerRepository = new CustomerRepository();
            Customer customer = customerRepository.find(selectedCustomerId);
            customerRepository.close();
            correspondence.setCustomer(customer);
        }
        System.out.println("Secilen Müşteri Kontağı kimligi " + selectedContactId);
        if (selectedContactId != 0) {

            ContactRepository contactRepository = new ContactRepository();
            Contact contact = contactRepository.find(selectedContactId);
            contactRepository.close();
            correspondence.setContact(contact);
        }
        
        System.out.println("Secilen Etiketler " + selectedHashTagId);
        if (selectedHashTagId != 0) {

            HashTagRepository hashTagRepository = new HashTagRepository();
            HashTag hashTag = hashTagRepository.find(selectedHashTagId);
            hashTagRepository.close();
            correspondence.setHashTag(hashTag);
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
    
