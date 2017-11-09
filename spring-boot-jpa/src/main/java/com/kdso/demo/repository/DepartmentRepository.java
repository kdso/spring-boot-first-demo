package com.kdso.demo.repository;

import com.kdso.demo.entity.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Deparment, Long> {

}