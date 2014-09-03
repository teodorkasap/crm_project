/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.godoro.crm.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author erolerten
 */

@Entity @Table(name="UserRole")
public class UserRole {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userRoleId")
    private long userRoleId;
    @Column(name="adminRole", nullable = false)
    private boolean adminRole;
    @Column(name="employeeRole", nullable = false)
    private boolean employeeRole;
    @Column(name="managerRole", nullable = false)
    private boolean managerRole;
    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private List<User> userList;

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public boolean isAdminRole() {
        return adminRole;
    }

    public void setAdminRole(boolean adminRole) {
        this.adminRole = adminRole;
    }

    public boolean isEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(boolean employeeRole) {
        this.employeeRole = employeeRole;
    }

    public boolean isManagerRole() {
        return managerRole;
    }

    public void setManagerRole(boolean managerRole) {
        this.managerRole = managerRole;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    
    
    
}
