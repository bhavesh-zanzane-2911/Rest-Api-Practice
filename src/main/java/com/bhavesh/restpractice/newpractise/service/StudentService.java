package com.bhavesh.restpractice.newpractise.service;

import com.bhavesh.restpractice.newpractise.exceptions.StudentNotFoundException;
import com.bhavesh.restpractice.newpractise.model.Student;
import com.bhavesh.restpractice.newpractise.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentByRollNo(int rollNo) {
        return studentRepository
                .findById(rollNo)
                .orElseThrow(() -> new StudentNotFoundException("Student with RollNo " + rollNo + " Not Found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudentByRollNo(int rollNo) {
        if (!studentRepository.existsById(rollNo)) {
            throw new StudentNotFoundException("Student with RollNo " + rollNo + " Not Found");
        }
        studentRepository.deleteById(rollNo);
    }

    public ResponseEntity<Object> saveStudent(@Valid Student student) {
        studentRepository.save(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{rollNo}").buildAndExpand(student.getRollNo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    public void updateStudent(Student student) {
        if (!studentRepository.existsById(student.getRollNo())) {
            throw new StudentNotFoundException("Student with RollNo " + student.getRollNo() + " Not Found");
        }
        studentRepository.save(student);
    }
}
