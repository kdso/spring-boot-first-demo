package com.kdso.demo.dao.impl;

import com.kdso.demo.User;
import com.kdso.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2017/10/29.
 */
@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User findByFirstName(String firstName) {
        Query query = new Query(Criteria.where("firstName").is(firstName));
        return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        Query query = new Query(Criteria.where("lastName").is(lastName));
        return mongoTemplate.find(query,User.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query);
    }
}
