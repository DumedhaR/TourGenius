package com.tourgenius.accountservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
@Data
@AllArgsConstructor
public class AccountIsAvailableException extends RuntimeException{

    private String fieldName;
    private Object fieldValue;

    @Override
    public String toString() {
        return String.format("Given '%s' is already used by another account!",fieldValue);
    }
}
