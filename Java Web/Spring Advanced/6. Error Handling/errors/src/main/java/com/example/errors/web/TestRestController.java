package com.example.errors.web;

import com.example.errors.exception.ObjectNotFoundException;
import com.example.errors.exception.ObjectNotFoundRestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/test-rest")
    public ResponseEntity<Student> get() {
        throw new ObjectNotFoundRestException("Student not found");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundRestException.class)
    public ErrorInfo handleNotFound(ObjectNotFoundRestException exception) {
        return new ErrorInfo(
                "/test-rest",
                exception);
    }

}

record Student(String name, int age) {
}

class ErrorInfo {
    public final String url;
    public final String ex;

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getMessage();
    }
}