package com.securde.shslibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Thea on 06/08/2017.
 */

@Entity
public class Role {
    @Id
    private int roleid;
    private String role;

    public Role(int roleid, String role) {
        this.roleid = roleid;
        this.role = role;
    }

    public Role() {
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
