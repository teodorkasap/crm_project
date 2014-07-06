/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.library.database;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author erol
 */
public class BaseRepository<E> {

    private EntityManager entityManager;
    private Class<E> entityClass;
    public BaseRepository(Class<E> entityClass) {
        this.entityClass=entityClass;
        entityManager = Persistence
                .createEntityManagerFactory("CrmProjectPU")
                .createEntityManager();
    }

    public void persist(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

    }
    public void merge(E entity){
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }
    public void remove(long entityId){
        E entity=entityManager.getReference(entityClass,entityId);
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
    
    public List<E> list(){
        String string=String.format("select e from %s as e",entityClass.getSimpleName());
        Query query=entityManager.createQuery(string);
        return query.getResultList();
    }
    public E find(long entityId){
        return entityManager.find(entityClass,entityId);
    }
    
    public void close() {
        entityManager.close();
    }
}
