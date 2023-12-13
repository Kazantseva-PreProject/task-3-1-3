package com.example.spring.boot_security.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itmentor.spring.boot_security.demo.util.exception.UserNotCreatedException;
import ru.itmentor.spring.boot_security.demo.util.exception.UserNotFoundException;

import java.util.List;

@Component
public class UserExcHandler {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handlerException(UserNotFoundException e) {
        UserErrorResponse response = new UserErrorResponse(
                "User is not found!", System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handlerException(UserNotCreatedException e) {
        UserErrorResponse response = new UserErrorResponse(
                e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public void checkUserNotFoundExc(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                errorMessage.append(error.getField())
                        .append(" — ")
                        .append(error.getDefaultMessage())
                        .append("; ");
            }
            throw new UserNotCreatedException(errorMessage.toString());
        }
    }
}
