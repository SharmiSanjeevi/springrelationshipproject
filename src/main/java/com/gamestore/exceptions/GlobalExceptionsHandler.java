package com.gamestore.exceptions;

import com.gamestore.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMessage();
        String path = request.getContextPath();
        // This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), status, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleOther(Exception ex) {
        String message = ex.getMessage();
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);

    }

    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFound(CategoryNotFoundException ex) {
        String message = ex.getMessage();
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
    }


    @ExceptionHandler(value = GameNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFound(GameNotFoundException ex) {
        String message = ex.getMessage();
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
    }

    @ExceptionHandler(value = PublisherNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFound(PublisherNotFoundException ex) {
        String message = ex.getMessage();
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
    }

    @ExceptionHandler(value = RequirementNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFound(RequirementNotFoundException ex) {
        String message = ex.getMessage();
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, message, path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
    }


}
