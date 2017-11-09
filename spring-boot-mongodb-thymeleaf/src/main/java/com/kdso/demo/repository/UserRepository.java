package com.kdso.demo.repository;

import com.kdso.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findById(long id);

    Long deleteById(Long id);
}