/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Correspondence;
import com.godoro.crm.entity.Customer;
import com.godoro.crm.entity.Event;
import com.godoro.crm.entity.HashTag;
import com.godoro.crm.entity.Product;
import com.godoro.crm.entity.Project;
import com.godoro.crm.entity.Tag;
import com.godoro.crm.repository.CorrespondenceRepository;
import com.godoro.crm.repository.HashTagRepository;
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
public class HashTagDetailBean {
    
    private HashTag hashTag;
    private List<Tag> tagList;
    private long selectedTagId;
    private List<Customer> customerList;
    private long selectedCustomerId;
    private List<Project> projectList;
    private long selectedProjectId;
    private List<Product> productList;
    private long selectedProductId;
    private List<Correspondence> correspondenceList;
    private long selectedCorrespondenceId;
    private List<Event> eventList;
    private long selectedEventId;

    public HashTag getHashTag() {
        return hashTag;
    }

    public void setHashTag(HashTag hashTag) {
        this.hashTag = hashTag;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public long getSelectedTagId() {
        return selectedTagId;
    }

    public void setSelectedTagId(long selectedTagId) {
        this.selectedTagId = selectedTagId;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public long getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedCustomerId(long selectedCustomerId) {
        this.selectedCustomerId = selectedCustomerId;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public long getSelectedProjectId() {
        return selectedProjectId;
    }

    public void setSelectedProjectId(long selectedProjectId) {
        this.selectedProjectId = selectedProjectId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public long getSelectedProductId() {
        return selectedProductId;
    }

    public void setSelectedProductId(long selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    public List<Correspondence> getCorrespondenceList() {
        return correspondenceList;
    }

    public void setCorrespondenceList(List<Correspondence> correspondenceList) {
        this.correspondenceList = correspondenceList;
    }

    public long getSelectedCorrespondenceId() {
        return selectedCorrespondenceId;
    }

    public void setSelectedCorrespondenceId(long selectedCorrespondenceId) {
        this.selectedCorrespondenceId = selectedCorrespondenceId;
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
     * Creates a new instance of HashTagDetailBean
     */
    public HashTagDetailBean() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
        long hashtagId = 0;
        if (request.getParameter("hashtagId") != null) {
            hashtagId = Long.parseLong(request.getParameter("hashtagId"));
        }else{
            if (hashtagId == 0) {
            hashTag = new HashTag();

        } else {
            HashTagRepository hashtagRepository = new HashTagRepository();
            hashTag = hashtagRepository.find(hashtagId);
            hashtagRepository.close();
        }
        }
        
            HashTagRepository hashtagRepository = new HashTagRepository();
            hashTag = hashtagRepository.find(hashtagId);
            hashtagRepository.close();
        
    }
    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long hashtagId = 0;

        if (request.getParameter("hashtagId") != null) {
            hashtagId = Long.parseLong(request.getParameter("hashtagId"));
        }
        
        HashTagRepository hashtagRepository = new HashTagRepository();
        if (hashtagId == 0) {
            hashtagRepository.persist(hashTag);
        } else {
            hashtagRepository.merge(hashTag);
        }
        hashtagRepository.close();
    }
    
}
