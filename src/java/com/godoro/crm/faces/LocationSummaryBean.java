/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Event;
import com.godoro.crm.entity.Location;
import com.godoro.crm.repository.EventRepository;
import com.godoro.crm.repository.LocationRepository;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class LocationSummaryBean {
    
    private List<Location> locationList;
    private List<Event> eventList;
    private long selectedEventId;

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public long getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(long selectedEventId) {
        this.selectedEventId = selectedEventId;
    }
    
    
    
    

    /**
     * Creates a new instance of LocationSummaryBean
     */
    public LocationSummaryBean() {
        
        
        LocationRepository locationRepository = new LocationRepository();
        locationList = locationRepository.list();
        locationRepository.close();
        
        EventRepository eventRepository = new EventRepository();
        eventList = eventRepository.list();
        eventRepository.close();
    }
    
    
    public void filter() {
        
        if (selectedEventId != 0) {
            LocationRepository locationRepository = new LocationRepository();
            locationList = locationRepository.listByEventId(selectedEventId);
            locationRepository.close();

        } else {

                LocationRepository locationRepository = new LocationRepository();
                locationList = locationRepository.list();
                locationRepository.close();
            }
        

    }
    
}
