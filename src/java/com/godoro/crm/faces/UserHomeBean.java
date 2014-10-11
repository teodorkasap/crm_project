/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class UserHomeBean {

    /**
     * Creates a new instance of UserHomeBean
     */
    public UserHomeBean() throws IOException {
        if(getUserName()==null){
             HttpServletResponse response = (HttpServletResponse) FacesContext
                .getCurrentInstance().getExternalContext().getResponse();
                response.sendRedirect("UserLoginPage.xhtml");
        }
    }
    public String getUserName (){
         HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);
         String userName = (String) session.getAttribute("userName");
        return userName;
        
    }
    
}
