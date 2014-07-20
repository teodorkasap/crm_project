/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Location;
import com.godoro.library.database.BaseRepository;

/**
 *
 * @author erolerten
 */
public class LocationRepository extends BaseRepository<Location>{
    public LocationRepository(){
        super(Location.class);
    }
    
}
