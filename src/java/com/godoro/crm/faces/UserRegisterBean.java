/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;


import com.godoro.crm.entity.User;
import com.godoro.crm.repository.UserRepository;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erol
 */
@ManagedBean
@RequestScoped
public class UserRegisterBean {
    private String userName;
    private String userPassword;
    private String passwordConfirmation;
    private String userEmail;
    private String userRole;
    public UserRegisterBean() {
        
        
        
        
        
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
    
    public void register(){
        if (userPassword.equals(passwordConfirmation)){
            User user=new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        UserRepository userRepository = new UserRepository();
        userRepository.persist(user);
        
        userRepository.close();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kaydiniz Basarili oldu"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("parola dogrulama basarisiz"));
        }
        
    }
    

    /**
     * Creates a new instance of UserRegisterBean
     */
    
    
    
}
