package com.fuzeto.fluentvalidator.business.validation.rules;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.LogicalPredicate;

import java.util.UUID;

import static br.com.fluentvalidator.predicate.LogicalPredicate.*;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.function.Predicate.not;

public class ChildrenDuplicatedValidator extends AbstractValidator<Boolean> {

    @Override
    public void rules() {
        ruleFor(Boolean::booleanValue)
                .must(isFalse())
                .withFieldName("children.id")
                .withMessage("Child id cannot be duplicated")
                .critical();
    }
}
