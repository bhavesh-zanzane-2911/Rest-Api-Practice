package com.bhavesh.restpractice.newpractise.exceptions.exceptionHandler;

import com.bhavesh.restpractice.newpractise.exceptions.StudentNotFoundException;
import com.bhavesh.restpractice.newpractise.exceptions.customizedexceptionreponse.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedEntityResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse ex1 = new ExceptionResponse(ex.getMessage(), new Date(), request.getDescription(false));
        return new ResponseEntity(ex1, HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String defaultMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        ExceptionResponse ex2 = new ExceptionResponse(defaultMessage, new Date(), request.getDescription(false));
        HttpStatus statusResponse = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(ex2, statusResponse);
    }
}
