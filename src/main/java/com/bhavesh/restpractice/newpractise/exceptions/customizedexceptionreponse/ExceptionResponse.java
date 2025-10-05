package com.bhavesh.restpractice.newpractise.exceptions.customizedexceptionreponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private String message;
    private Date timestamp;
    private String details;
}
