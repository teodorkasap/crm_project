/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.Event;
import com.godoro.crm.entity.HashTag;
import com.godoro.crm.entity.Location;
import com.godoro.crm.entity.Participant;
import com.godoro.crm.repository.EventRepository;
import com.godoro.crm.repository.LocationRepository;
import com.godoro.crm.repository.ParticipantRepository;
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
public class EventDetailBean {
    
    private Event event;
    private List<Participant> participantList;
    private long selectedParticipantId;
    private List<Location> locationList;
    private long selectedLocationId;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;
    private List<Customer> customerList;
    private long selectedCustomerId;
    
    

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    
    

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<HashTag> getHashTagList() {
        return hashTagList;
    }

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }

    public long getSelectedParticipantId() {
        return selectedParticipantId;
    }

    public void setSelectedParticipantId(long selectedParticipantId) {
        this.selectedParticipantId = selectedParticipantId;
    }

    public long getSelectedLocationId() {
        return selectedLocationId;
    }

    public void setSelectedLocationId(long selectedLocationId) {
        this.selectedLocationId = selectedLocationId;
    }

    public long getSelectedHashTagId() {
        return selectedHashTagId;
    }

    public void setSelectedHashTagId(long selectedHashTagId) {
        this.selectedHashTagId = selectedHashTagId;
    }

    public long getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedCustomerId(long selectedCustomerId) {
        this.selectedCustomerId = selectedCustomerId;
    }
    
    
    

    /**
     * Creates a new instance of EventDetailBean
     */
    public EventDetailBean() {
        
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long eventId = 0;
        if (request.getParameter("eventId") != null) {
            eventId = Long.parseLong(request.getParameter("eventId"));
        }else{
            if (eventId == 0) {
            event = new Event();

        } else {
            EventRepository eventRepository = new EventRepository();
            event = eventRepository.find(eventId);
            eventRepository.close();
        }
        }
        
            EventRepository eventRepository = new EventRepository();
            event = eventRepository.find(eventId);
            eventRepository.close();
        
        
    }

    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long eventId = 0;

        if (request.getParameter("eventId") != null) {
            eventId = Long.parseLong(request.getParameter("eventId"));
        }
        System.out.println("Secilen Toplanti Yeri kimligi " + selectedLocationId);
        if (selectedLocationId != 0) {

            LocationRepository locationRepository = new LocationRepository();
            Location location = locationRepository.find(selectedLocationId);
            locationRepository.close();
            event.setLocation(location);
        }
         System.out.println("Secilen Toplanti Katilimci kimligi " + selectedParticipantId);
        if (selectedParticipantId != 0) {

            ParticipantRepository participantRepository = new ParticipantRepository();
            Participant participant = participantRepository.find(selectedParticipantId);
            participantRepository.close();
            event.setParticipant(participant);
        }
        
        EventRepository eventRepository = new EventRepository();
        if (eventId == 0) {
            eventRepository.persist(event);
        } else {
            eventRepository.merge(event);
        }
        eventRepository.close();
    }
    
}
