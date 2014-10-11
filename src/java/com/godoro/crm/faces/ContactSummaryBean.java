/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.crm.faces;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Correspondence;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.HashTag;
import com.godoro.crm.entity.Participant;
import com.godoro.crm.repository.ContactRepository;
import com.godoro.crm.repository.CorrespondenceRepository;
import com.godoro.crm.repository.CustomerRepository;
import com.godoro.crm.repository.HashTagRepository;
import com.godoro.crm.repository.ParticipantRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class ContactSummaryBean {

    private List<Contact> contactList;
    private List<Customer> customerList;
    private long selectedCustomerId;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;
    private List<Correspondence> correspondenceList;
    private long selectedCorrespondenceId;
    private List<Participant> participantList;
    private long selectedParticipantId;

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public long getSelectedcustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedcustomerId(long selectedcustomerId) {
        this.selectedCustomerId = selectedcustomerId;
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

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public long getSelectedParticipantId() {
        return selectedParticipantId;
    }

    public void setSelectedParticipantId(long selectedParticipantId) {
        this.selectedParticipantId = selectedParticipantId;
    }

    /**
     * Creates a new instance of ContactSummaryBean
     */
    public ContactSummaryBean() {

        ContactRepository contactRepository = new ContactRepository();
        contactList = contactRepository.list();
        contactRepository.close();

        CustomerRepository customerRepository = new CustomerRepository();
        customerList = customerRepository.list();
        customerRepository.close();

        HashTagRepository hashTagRepository = new HashTagRepository();
        hashTagList = hashTagRepository.list();
        hashTagRepository.close();

        CorrespondenceRepository correspondenceRepository = new CorrespondenceRepository();
        correspondenceList = correspondenceRepository.list();
        correspondenceRepository.close();

        ParticipantRepository participantRepository = new ParticipantRepository();
        participantList = participantRepository.list();
        participantRepository.close();

    }

    public void filter() {
        System.out.println("Secilen Musteri kimligi " + selectedCustomerId);
        if (selectedCustomerId != 0) {
            ContactRepository contactRepository = new ContactRepository();
            contactList = contactRepository.listByCustomerId(selectedCustomerId);
            contactRepository.close();

        } else {
            if (selectedHashTagId != 0) {
                ContactRepository contactRepository = new ContactRepository();
                contactList = contactRepository.listByHashTagId(selectedHashTagId);
                contactRepository.close();
            } else {
                if (selectedCorrespondenceId != 0) {
                    ContactRepository contactRepository = new ContactRepository();
                    contactList = contactRepository.listByCorrespondenceId(selectedCorrespondenceId);
                    contactRepository.close();

                } else {
                    if (selectedParticipantId != 0) {
                        ContactRepository contactRepository = new ContactRepository();
                        contactList = contactRepository.listByParticipantId(selectedParticipantId);
                        contactRepository.close();

                    } else {

                        ContactRepository contactRepository = new ContactRepository();
                        contactList = contactRepository.list();
                        contactRepository.close();
                    }
                }

            }
        }
    }

    }
