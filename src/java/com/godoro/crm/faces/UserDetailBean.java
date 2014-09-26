/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.faces;

import com.godoro.crm.entity.Employee;
import com.godoro.crm.entity.User;

import com.godoro.crm.repository.EmployeeRepository;
import com.godoro.crm.repository.UserRepository;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erolerten
 */
@ManagedBean
@RequestScoped
public class UserDetailBean {

    private User user;
    
    private long selectedUserRoleId;
    private List<Employee> employeeList;
    private long selectedEmployeeId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   

    public long getSelectedUserRoleId() {
        return selectedUserRoleId;
    }

    public void setSelectedUserRoleId(long selectedUserRoleId) {
        this.selectedUserRoleId = selectedUserRoleId;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public long getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(long selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }
    
    
    
    /**
     * Creates a new instance of UserDetailBean
     */
    public UserDetailBean() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long userId = 0;
        if (request.getParameter("userId") != null) {
            userId = Long.parseLong(request.getParameter("userId"));
        }
        if (userId == 0) {
            user = new User();

        } else {
            UserRepository userRepository = new UserRepository();
            user = userRepository.find(userId);
            userRepository.close();
        }

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeList = employeeRepository.list();
        employeeRepository.close();
        
       
    }
    
    public void save() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        long userId = 0;

        if (request.getParameter("userId") != null) {
            userId = Long.parseLong(request.getParameter("userId"));
        }
        System.out.println("Secilen Okul kimligi " + selectedEmployeeId);
        if (selectedEmployeeId != 0) {

            EmployeeRepository employeeRepository = new EmployeeRepository();
            Employee employee = employeeRepository.find(selectedEmployeeId);
            employeeRepository.close();
            user.setEmployee(employee);
        }
        
        UserRepository userRepository = new UserRepository();
        if (userId == 0) {
            userRepository.persist(user);
        } else {
            userRepository.merge(user);
        }
        userRepository.close();
    }
    
}
