package com.kdso.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2017/11/10.
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/save")
    public void saveTask() {
        User user = new User();
        user.setName("admin");
        userRepository.save(user);
    }


    @RequestMapping(value = "/findByName")
    public User findByName(String name) {
        User user = userRepository.findByName(name);
        return user;
    }

}
