package com.equotationpenguin.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private String resourceFileNme;
    private Object fieldValue;
    private final HttpStatus httpStatus;

    public ResourceNotFoundException(String resourceName, String resourceFileNme, Object fieldValue, HttpStatus httpStatus) {
        //super(String.format("%s not found with: %s= '%s'", resourceName, resourceFileNme, fieldValue));
        super(resourceName);
        this.resourceName = resourceName;
        this.resourceFileNme = resourceFileNme;
        this.fieldValue = fieldValue;
        this.httpStatus = httpStatus;
    }

    public ResourceNotFoundException(String resourceName, HttpStatus httpStatus) {
        super(String.format("Register not founds of %s en el application ", resourceName));
        this.resourceName = resourceName;
        this.httpStatus = httpStatus;
    }
}
