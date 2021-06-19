package com.bhavesh.restpractice.newpractise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String s) {
        super(s);
    }
    public StudentNotFoundException(String s, Exception ex) {
        super(s, ex);
    }
}
