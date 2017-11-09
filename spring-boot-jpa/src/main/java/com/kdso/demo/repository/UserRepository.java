package com.kdso.demo.repository;

import com.kdso.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;


public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    Long deleteById(Long id);


}