/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.HashTag;
import com.godoro.crm.entity.Tag;
import com.godoro.crm.repository.HashTagRepository;
import com.godoro.crm.repository.TagRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class TagDetailBean {
    
    private Tag tag;
    private List<HashTag> hashTagList;
    private long selectedHashTagId;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<HashTag> getHashTagList() {
        return hashTagList;
    }

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }

    public long getSelectedHashTagId() {
        return selectedHashTagId;
    }

    public void setSelectedHashTagId(long selectedHashTagId) {
        this.selectedHashTagId = selectedHashTagId;
    }
    
    
    
    

    /**
     * Creates a new instance of TagDetailBean
     */
    public TagDetailBean() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long tagId = 0;
        if (request.getParameter("tagId") != null) {
            tagId = Long.parseLong(request.getParameter("tagId"));
        }
        if (tagId == 0) {
            tag = new Tag();

        } else {
            TagRepository tagRepository = new TagRepository();
            tag = tagRepository.find(tagId);
            tagRepository.close();
        }

        HashTagRepository hashTagRepository = new HashTagRepository();
        hashTagList = hashTagRepository.list();
        hashTagRepository.close();
        
        
        
    }
    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long tagId = 0;

        if (request.getParameter("tagId") != null) {
            tagId = Long.parseLong(request.getParameter("tagId"));
        }
        
        System.out.println("Secilen Etiketler " + selectedHashTagId);
        if (selectedHashTagId != 0) {

            HashTagRepository hashTagRepository = new HashTagRepository();
            HashTag hashTag = hashTagRepository.find(selectedHashTagId);
            hashTagRepository.close();
            tag.setHashTag(hashTag);
        }
       
        TagRepository tagRepository = new TagRepository();
        if (tagId == 0) {
            tagRepository.persist(tag);
        } else {
            tagRepository.merge(tag);
        }
        tagRepository.close();
    }
    
}
