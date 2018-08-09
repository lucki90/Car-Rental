package com.sda.luckyrent.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;

public class BindingResultException extends RuntimeException{

    @Getter
    private final BindingResult bindingResult;

    public BindingResultException(BindingResult bindingResult) {
        super();
        this.bindingResult = bindingResult;
    }
}
