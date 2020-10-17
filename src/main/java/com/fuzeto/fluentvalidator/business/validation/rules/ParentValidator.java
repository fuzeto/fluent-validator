package com.fuzeto.fluentvalidator.business.validation.rules;

import br.com.fluentvalidator.AbstractValidator;
import com.fuzeto.fluentvalidator.domain.model.Child;
import com.fuzeto.fluentvalidator.domain.model.Parent;

import java.util.*;
import java.util.stream.Collectors;

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
                .withMessage("Parent name cannot be null or empty")
                .critical();

        ruleFor(Parent::getAge)
                .must(not(nullValue()))
                .withFieldName("age")
                .withMessage("Age cannot be null or empty")
                .critical();

        ruleFor(Parent::getCities)
                .must(not(nullValue()))
                .withFieldName("cities")
                .withMessage("Cities cannot be null or empty")
                .critical();

        ruleFor(Parent::getChildren)
                .must(not(nullValue()))
                .withFieldName("childs")
                .withMessage("Childs cannot be null or empty")
                .critical();

        ruleForEach(parent -> extractChildrenId(parent.getChildren()))
                .whenever(not(nullValue()))
                    .withValidator(new ChildrenEmptyIdValidator())
                    .critical();

        ruleFor(parent -> hasDuplicateChildrenId(parent.getChildren()))
                .whenever(not(nullValue()))
                .withValidator(new ChildrenDuplicatedValidator())
                .critical();

    }

    private Collection<UUID> extractChildrenId(Collection<Child> children) {
        return Optional.ofNullable(children).orElseGet(ArrayList::new)
                .stream()
                .map(Child::getId)
                .collect(Collectors.toList());
    }

    private Boolean hasDuplicateChildrenId(Collection<Child> children) {
        List<UUID> uuids = children.stream()
                .map(Child::getId)
                .collect(Collectors.toList());

        Set<UUID> totalUuids = uuids.stream()
                .filter(i -> Collections.frequency(uuids, i) > 1)
                .collect(Collectors.toSet());

        return totalUuids.size() > 0;
    }
}
