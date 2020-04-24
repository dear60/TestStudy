package com.mingful.www.testshiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "permission_t")
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 353629772108330570L;
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(name = "role_permission_t", joinColumns = {@JoinColumn(name = "pid")}, inverseJoinColumns = {@JoinColumn(name = "rid")})
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
