/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;


import com.godoro.crm.entity.User;
import com.godoro.crm.repository.UserRepository;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author erol
 */
@ManagedBean
@RequestScoped
public class UserLoginBean {
    
    
    private String userName;
    private String userPassword;
    
    public UserLoginBean() {
        
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

    public void login () throws IOException{
        
        UserRepository userRepository=new UserRepository();
        User user=userRepository.selectByUsername(userName);
        if (user==null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Boyle Bir Kullanici Kayitli Degil"));
            
        }else {
            if (!userPassword.equals(user.getUserPassword())){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanici Sifre veya Ismi yanlis"));
                
            }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Giris Basarili"));   
                HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("userName", userName);
                HttpServletResponse response = (HttpServletResponse) FacesContext
                .getCurrentInstance().getExternalContext().getResponse();
                response.sendRedirect("UserHomePage.xhtml");
                
            }
        }
    }
    
    
    
}
