package com.bhavesh.restpractice.newpractise.service;

import com.bhavesh.restpractice.newpractise.exceptions.StudentNotFoundException;
import com.bhavesh.restpractice.newpractise.model.Student;
import com.bhavesh.restpractice.newpractise.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {
    static List<Student> studentList = new ArrayList<>();

    private final StudentRepository studentRepository;

    static {
        studentList.add(new Student(1, "Adesh", "Pune"));
        studentList.add(new Student(2, "Bhavesh", "Baramati"));
        studentList.add(new Student(3, "Pooja", "Indapur"));
    }

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(int rollNo) {
        for (Student student : studentList) {
            if (student.getRollNo() == rollNo) {
                return student;
            }
        }

        return null;
    }

    public Student getStudentByRollNo(int rollNo){
        return studentRepository
                .findById(rollNo)
                .orElseThrow(()->new StudentNotFoundException("Student with RollNo " + rollNo + " Not Found"));
    }

    public List<Student> findAllStudents() {
        return studentList;
    }

    public void deleteById(int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            if (next.getRollNo() == id) {
                iterator.remove();
            }
        }
    }

    public void updateStudentDetails(Student student) {

        for (Student s : studentList) {
            if (s.getRollNo() == student.getRollNo()) {
                s.setCity(student.getCity());
                s.setName(student.getName());
            }
        }

    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudentByRollNo(int rollNo) {
        if(!studentRepository.existsById(rollNo)) {
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
        if(!studentRepository.existsById(student.getRollNo())) {
            throw new StudentNotFoundException("Student with RollNo " + student.getRollNo() + " Not Found");
        }
        studentRepository.save(student);
    }
}
