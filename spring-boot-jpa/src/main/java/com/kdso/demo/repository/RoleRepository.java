package com.kdso.demo.repository;

import com.kdso.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

}