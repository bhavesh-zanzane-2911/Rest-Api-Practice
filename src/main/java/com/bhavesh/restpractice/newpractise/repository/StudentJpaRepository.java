package com.bhavesh.restpractice.newpractise.repository;

import com.bhavesh.restpractice.newpractise.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

}
