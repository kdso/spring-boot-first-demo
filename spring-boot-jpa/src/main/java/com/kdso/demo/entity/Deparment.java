package com.kdso.demo.entity;

import javax.persistence.*;

/**
 * Created by asus on 2017/11/7.
 * 部门表
 */
@Entity
public class Deparment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Deparment() {
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
}
