/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.repository;

import com.godoro.crm.entity.User;
import com.godoro.library.database.BaseRepository;

/**
 *
 * @author erolerten
 */
public class UserRepository extends BaseRepository<User>{
    public UserRepository(){
        super(User.class);
    }
    
    
    
}
