package bg.softuni.mvcdemo.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advices {

    @ExceptionHandler
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exception) {
        System.out.println(exception.getMessage());

        return ResponseEntity
                .notFound()
                .build();
    }
}
