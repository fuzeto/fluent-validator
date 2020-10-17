package com.fuzeto.fluentvalidator.business.validation.impl;

import br.com.fluentvalidator.context.ValidationResult;
import com.fuzeto.fluentvalidator.business.validation.IParentRule;
import com.fuzeto.fluentvalidator.business.validation.rules.ParentValidator;
import com.fuzeto.fluentvalidator.domain.model.Parent;
import com.fuzeto.fluentvalidator.web.exception.PersistenceValidationException;
import org.springframework.stereotype.Service;

@Service
public class ParentRuleImpl implements IParentRule {

    @Override
    public ValidationResult validate(Parent parent) {

        ValidationResult result = new ParentValidator().validate(parent);

        if (!result.isValid()) {
            throw new PersistenceValidationException(result.getErrors());
        }

        return null;
    }
}
