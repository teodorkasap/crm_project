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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erol
 */
@ManagedBean
@RequestScoped
public class UserLogoutBean {
    private String message;

    public String getMessage() {
        return message;
    }

    /**
     * Creates a new instance of UserLogoutBean
     */
    public UserLogoutBean() throws IOException {
        HttpSession session = (HttpSession) FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);
        session.removeAttribute("userName");

        message = "cikis basarili";

    }

}
