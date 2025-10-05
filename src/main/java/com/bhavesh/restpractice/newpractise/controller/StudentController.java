package com.bhavesh.restpractice.newpractise.controller;

import com.bhavesh.restpractice.newpractise.model.Student;
import com.bhavesh.restpractice.newpractise.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : Bhavesh Zanzane
 * Description : Rest API using Spring Boot an Spring Data JPA
 */


@RestController()
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{rollNo}")
    public Student getStudentByRollNo(@PathVariable int rollNo) {
        return studentService.getStudentByRollNo(rollNo);
    }


    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping(path = "/{rollNo}")
    public void deleteStudent(@PathVariable int rollNo) {
        studentService.deleteStudentByRollNo(rollNo);
    }

    @PostMapping()
    public ResponseEntity<Object> addStudentDetails(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping()
    public void updateStudentDetails(@RequestBody Student student) {
        studentService.updateStudent(student);
    }
}
