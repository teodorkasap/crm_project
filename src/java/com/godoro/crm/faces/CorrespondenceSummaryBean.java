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

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class CorrespondenceSummaryBean {

    private List<Correspondence> correspondenceList;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;
    private List<Employee> employeeList;
    private long selectedEmployeeId;
    private List<Customer> customerList;
    private long selectedCustomerId;
    private List<Contact> contactList;
    private long selectedContactId;

    public List<Correspondence> getCorrespondenceList() {
        return correspondenceList;
    }

    public void setCorrespondenceList(List<Correspondence> correspondenceList) {
        this.correspondenceList = correspondenceList;
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
     * Creates a new instance of CorrespondenceSummaryBean
     */
    public CorrespondenceSummaryBean() {

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

    }

    public void filter() {
        System.out.println("Secilen Yazisma kimligi " + selectedCustomerId);
        if (selectedCustomerId != 0) {
            CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
            correspondenceList = correspondenceRepository.listByCustomerId(selectedCustomerId);
            correspondenceRepository.close();

        } else {
            if (selectedHashTagId != 0) {
                CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
                correspondenceList = correspondenceRepository.listByHashTagId(selectedHashTagId);
                correspondenceRepository.close();
            } else {
                if (selectedEmployeeId != 0) {
                    CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
                    correspondenceList = correspondenceRepository.listByEmployeeId(selectedEmployeeId);
                    correspondenceRepository.close();

                } else {
                    if (selectedCustomerId != 0) {
                        CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
                        correspondenceList = correspondenceRepository.listByCustomerId(selectedCustomerId);
                        correspondenceRepository.close();

                    } else {

                        if (selectedContactId != 0) {

                            CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
                            correspondenceList = correspondenceRepository.listByContactId(selectedContactId);
                            correspondenceRepository.close();
                        } else {

                            CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
                            correspondenceList = correspondenceRepository.list();
                            correspondenceRepository.close();
                        }
                    }

                }
            }
        }

    }
}
