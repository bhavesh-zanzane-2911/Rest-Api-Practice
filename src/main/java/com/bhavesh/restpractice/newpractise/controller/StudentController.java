package com.bhavesh.restpractice.newpractise.controller;

import com.bhavesh.restpractice.newpractise.exceptions.StudentNotFoundException;
import com.bhavesh.restpractice.newpractise.model.Student;
import com.bhavesh.restpractice.newpractise.repository.StudentJpaRepository;
import com.bhavesh.restpractice.newpractise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * @Author : Bhavesh Zanzane
 * Description : Rest API using Spring Boot an Spring Data JPA
 */


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @GetMapping(path = "students/{rollNo}")
    public Student getStudentByRollNo(@PathVariable int rollNo) {
        Optional<Student> byId = studentJpaRepository.findById(rollNo);
        boolean present = byId.isPresent();
        if (!present)
            throw new StudentNotFoundException("Student with RollNo " + rollNo + " Not Found");
        return byId.get();
    }


    @GetMapping(path = "students")
    public List<Student> getAllStudents() {
        return studentJpaRepository.findAll();
    }

    @DeleteMapping(path = "students/{rollNo}")
    public void deleteById(@PathVariable int rollNo) {
        Optional<Student> byId = studentJpaRepository.findById(rollNo);
        if (!byId.isPresent())
            throw new StudentNotFoundException("User with Id " + rollNo + " Not found");
        studentJpaRepository.deleteById(rollNo);

    }

    @PostMapping("students")
    public ResponseEntity<Object> addStudentDetails(@Valid @RequestBody Student student) {
        studentJpaRepository.save(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{rollNo}").buildAndExpand(student.getRollNo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("students")
    public void updateStudentDetails(@RequestBody Student student) {
        studentJpaRepository.save(student);
    }
}
