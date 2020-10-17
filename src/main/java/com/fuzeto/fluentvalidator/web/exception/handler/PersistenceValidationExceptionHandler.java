package com.fuzeto.fluentvalidator.web.exception.handler;

import br.com.fluentvalidator.context.Error;
import com.fuzeto.fluentvalidator.web.exception.Field;
import com.fuzeto.fluentvalidator.web.exception.Message;
import com.fuzeto.fluentvalidator.web.exception.PersistenceValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class PersistenceValidationExceptionHandler {

    @ExceptionHandler(PersistenceValidationException.class)
    public ResponseEntity<Object> handle(PersistenceValidationException ex) {

        Collection<Error> errors = ex.getErrors();

        List<Field> fields = errors.stream()
                .map(error -> Field.builder()
                        .field(error.getField())
                        .message(error.getMessage())
                        .value("")
                        .build()
                )
                .collect(Collectors.toList());

        Message exception = Message.builder()
                .code("validation_error")
                .message("Some invalid fields")
                .fields(fields)
                .build();

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
