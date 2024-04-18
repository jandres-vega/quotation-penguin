package com.equotationpenguin.exceptions;

import com.equotationpenguin.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request){

        Map<String, String> mapErrors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(err -> {
            String errMsg = err.getDefaultMessage();
            String clave = ((FieldError) err).getField();
            mapErrors.put(clave, errMsg);
        });

        ApiResponse apiResponse = new ApiResponse(mapErrors.toString(), request.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(apiResponse, exception.getHttpStatus());
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse> handleAuthenticationException(AuthenticationException exception, WebRequest request) {
        ApiResponse apiResponse = new ApiResponse("Email o contraseña incorrectos.", request.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    }
}
