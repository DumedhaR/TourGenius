package com.tourgenius.accountservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
@AllArgsConstructor
public class AccountNotFoundException extends RuntimeException {
        private String fieldName;
        private Object fieldValue;

    @Override
    public String toString() {
        return String.format("No account is available for '%s'!",fieldValue);
    }
}
