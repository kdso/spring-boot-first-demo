package com.kdso.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public void deleteById(String id);

}
