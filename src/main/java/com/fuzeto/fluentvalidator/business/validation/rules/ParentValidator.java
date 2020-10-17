package com.fuzeto.fluentvalidator.business.validation.rules;

import br.com.fluentvalidator.AbstractValidator;
import com.fuzeto.fluentvalidator.domain.model.Parent;

import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.*;
import static java.util.function.Predicate.*;

public class ParentValidator extends AbstractValidator<Parent> {

    @Override
    public void rules() {
        setPropertyOnContext(Parent.class.getName());

        ruleFor(Parent::getName)
                .must(not(stringEmptyOrNull()))
                .withFieldName("name")
                .withMessage("Parent name can not be null or empty")
                .critical();

        ruleFor(Parent::getAge)
                .must(not(nullValue()))
                .withFieldName("age")
                .withMessage("Age can not be null or empty")
                .critical();
    }
}
