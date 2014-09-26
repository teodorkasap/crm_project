/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.crm.repository;

import com.godoro.crm.entity.User;
import com.godoro.library.database.BaseRepository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author erolerten
 */
public class UserRepository extends BaseRepository<User> {

    private EntityManager entityManager;

    public UserRepository() {
        super(User.class);
    }

    public User selectByUsername(String userName) {
        try {
            String string = "select user from User as user "
                    + " where user.userName= :userName";
            Query query = entityManager.createQuery(string);
            query.setParameter("userName", userName);
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }

    }

}
