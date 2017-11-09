package com.kdso.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/*
* 用户表
* */

@Entity
@Table(name = "user")
public class User{

    @Id
    @GeneratedValue
    public Long id;
    @Column(nullable = false)
    public String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createDate;


    @ManyToOne
    @JoinColumn(name = "did")
    @JsonBackReference //防止关系对象的递归访问
    private Deparment deparment;

    @ManyToMany(cascade = {},fetch = FetchType.EAGER)
    @JoinTable(name = "user_role"
            ,joinColumns = {@JoinColumn(name = "user_id")}
            ,inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private List<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Deparment getDeparment() {
        return deparment;
    }

    public void setDeparment(Deparment deparment) {
        this.deparment = deparment;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

