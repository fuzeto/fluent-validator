package com.fuzeto.fluentvalidator.web.exception;

import br.com.fluentvalidator.context.Error;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersistenceValidationException extends RuntimeException {

    private Collection<Error> errors;
}
