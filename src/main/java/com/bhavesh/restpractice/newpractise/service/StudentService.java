package com.bhavesh.restpractice.newpractise.service;

import com.bhavesh.restpractice.newpractise.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {
    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "Adesh", "Pune"));
        studentList.add(new Student(2, "Bhavesh", "Baramati"));
        studentList.add(new Student(3, "Pooja", "Indapur"));
    }

    public Student findById(int rollNo) {
        for (Student student : studentList) {
            if (student.getRollNo() == rollNo) {
                return student;
            }
        }

        return null;
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

}
