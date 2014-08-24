/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Location;
import com.godoro.crm.entity.Event;
import com.godoro.crm.entity.Location;
import com.godoro.crm.repository.LocationRepository;
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
public class LocationDetailBean {
    
    private Location location;
    private List<Event> eventList;
    private long selectedEventId;
    
   

    /**
     * Creates a new instance of LocationDetailBean
     */
    public LocationDetailBean() {
        
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long locationId = 0;
        if (request.getParameter("locationId") != null) {
            locationId = Long.parseLong(request.getParameter("locationId"));
        }else{
            if (locationId == 0) {
            location = new Location();

        } else {
            LocationRepository locationRepository = new LocationRepository();
            location = locationRepository.find(locationId);
            locationRepository.close();
        }
        }
        
            LocationRepository locationRepository = new LocationRepository();
            location = locationRepository.find(locationId);
            locationRepository.close(); 
    }
    
    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long locationId = 0;

        if (request.getParameter("locationId") != null) {
            locationId = Long.parseLong(request.getParameter("locationId"));
        }
        LocationRepository locationRepository = new LocationRepository();
        if (locationId == 0) {
            locationRepository.persist(location);
        } else {
            locationRepository.merge(location);
        }
        locationRepository.close();
    }
    
}
