/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.Lead;
import com.godoro.library.database.BaseRepository;

/**
 *
 * @author erolerten
 */
public class LeadRepository extends BaseRepository<Lead>{

    public LeadRepository(){
        super(Lead.class);
    }
    
    
}
