/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.crm.repository;

import com.godoro.crm.entity.Contact;
import com.godoro.crm.entity.Location;
import com.godoro.library.database.BaseRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author erolerten
 */
public class LocationRepository extends BaseRepository<Location> {
    private EntityManager entityManager;
    public LocationRepository() {
        super(Location.class);
    }

    public List<Location> listByEventId(long eventId) {
        String string = "select location from Location as location "
                + " where location.event.eventId= :eventId";
        Query query = entityManager.createQuery(string);
        query.setParameter("eventId", eventId);
        return query.getResultList();
    }

}
