package com.kdso.demo;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by asus on 2017/11/10.
 */
public interface UserRepository extends GraphRepository<User> {
    User findByName(@Param("name") String name);
}
