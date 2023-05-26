package com.example.diploma.eror;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final ErrorAttributes errorAttributes;

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Map<String, Object>> appException(AppException exception, WebRequest request) {
        Map<String, Object> body = errorAttributes.getErrorAttributes(request, exception.getOptions());
        HttpStatusCode statusCode = exception.getStatusCode();
        HttpStatus status = HttpStatus.valueOf(statusCode.value());
//        HttpStatus status = (HttpStatus) exception.getStatusCode();
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        return ResponseEntity.status(status).body(body);
    }
}
