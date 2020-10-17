package com.fuzeto.fluentvalidator.business.validation.rules;

import br.com.fluentvalidator.AbstractValidator;

import java.util.UUID;

import static br.com.fluentvalidator.predicate.StringPredicate.*;
import static java.util.function.Predicate.*;

public class ChildrenEmptyIdValidator extends AbstractValidator<UUID> {

    @Override
    public void rules() {
        ruleFor(UUID::toString)
                .must(not(stringEmptyOrNull()))
                .withFieldName("children.id")
                .withMessage("Child ID cannot be null or empty")
                .critical();
    }
}
