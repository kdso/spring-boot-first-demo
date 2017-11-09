package com.kdso.demo.dao;

import com.kdso.demo.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2017/10/29.
 */
public interface UserDao {
    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public void deleteById(String id);
}
