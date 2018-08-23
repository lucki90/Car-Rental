package com.sda.luckyrent.controller;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.IllegalActionException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.exception.UnavailableException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionMessage handleNotFoundException(NotFoundException e){
        return new ExceptionMessage(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ExceptionMessage handleUnavailableException(UnavailableException e){
        return new ExceptionMessage(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ExceptionMessage handleIllegalActionException(IllegalActionException e){
        return new ExceptionMessage(e.getMessage());
    }

    @ExceptionHandler(BindingResultException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleBindingResultsException (BindingResultException e){
        return getErrors(e.getBindingResult());
    }

    private Map<String, String> getErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }

    class ExceptionMessage {

        @Getter
        private String message;

        ExceptionMessage(String message) {
            this.message = message;
        }
    }

}
