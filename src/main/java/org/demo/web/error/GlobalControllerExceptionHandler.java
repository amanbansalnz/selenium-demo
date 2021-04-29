package org.demo.web.error;

import org.demo.web.model.response.GenericErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public GenericErrorResponse handleConversion(ApplicationException ex) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setCode(ex.getCode());
        genericErrorResponse.setMessage(ex.getMessage());
        return genericErrorResponse;
    }
}
