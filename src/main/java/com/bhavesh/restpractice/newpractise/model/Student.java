package com.bhavesh.restpractice.newpractise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {

    @Id
    @Column(name = "ROLL_NO")
    private int rollNo;
    @Size(min = 2, message = "Size should be at least 2 characters")
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "CITY")
    private String city;

}
