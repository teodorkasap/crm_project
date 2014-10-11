/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Participant;
import com.godoro.crm.repository.ContactRepository;
import com.godoro.crm.repository.EmployeeRepository;
import com.godoro.crm.repository.ParticipantRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class ParticipantDetailBean {
    
    private Participant participant;
    private List<Contact> contactList;
    private long selectedContactId;
    private List<Employee> employeeList;
    private long selectedEmployeeId;
    

    /**
     * Creates a new instance of ParticipantDetailBean
     */
    public ParticipantDetailBean() {
        
        
        
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long participantId = 0;
        if (request.getParameter("participantId") != null) {
            participantId = Long.parseLong(request.getParameter("participantId"));
        }else{
            if (participantId == 0) {
            participant = new Participant();

        } else {
            ParticipantRepository participantRepository = new ParticipantRepository();
            participant = participantRepository.find(participantId);
            participantRepository.close();
        }
        }
        
            ParticipantRepository participantRepository = new ParticipantRepository();
            participant = participantRepository.find(participantId);
            participantRepository.close(); 
    }
    
    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long participantId = 0;

        if (request.getParameter("participantId") != null) {
            participantId = Long.parseLong(request.getParameter("participantId"));
        }
        System.out.println("Secilen Musteri kimligi " + selectedContactId);
        if (selectedContactId != 0) {

            ContactRepository contactRepository = new ContactRepository();
            Contact contact = contactRepository.find(selectedContactId);
            contactRepository.close();
            participant.setContact(contact);
        }
        System.out.println("Secilen Calisan kimligi " + selectedEmployeeId);
        if (selectedEmployeeId != 0) {

            EmployeeRepository employeeRepository = new EmployeeRepository();
            Employee employee = employeeRepository.find(selectedEmployeeId);
            employeeRepository.close();
            participant.setEmployee(employee);
        }
        ParticipantRepository participantRepository = new ParticipantRepository();
        if (participantId == 0) {
            participantRepository.persist(participant);
        } else {
            participantRepository.merge(participant);
        }
        participantRepository.close();
    }
    
}
