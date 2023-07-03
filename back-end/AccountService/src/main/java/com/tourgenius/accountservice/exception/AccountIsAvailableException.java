package com.tourgenius.accountservice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
@Data
public class AccountIsAvailableException extends RuntimeException{

    private Object fieldValue;

    public AccountIsAvailableException(Object fieldValue){
        super(String.format("Given '%s' is already used by another account!",fieldValue));
        this.fieldValue = fieldValue;
    }
}
