package com.bhavesh.restpractice.newpractise.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Student Moel")
@Entity
public class Student {

    @Id
    @Column(name = "ROLL_NO")
    private int rollNo;
    @ApiModelProperty(notes = "Size should be at least 2 characters")
    @Size(min = 2, message = "Size should be at least 2 characters")
    @Column(name = "NAME")
    private String name;

    @ApiModelProperty(allowEmptyValue = false)
    @NotNull
    @Column(name = "CITY")
    private String city;

    public Student() {
    }

    public Student(int rollNo, String name, String city) {
        this.rollNo = rollNo;
        this.name = name;
        this.city = city;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
