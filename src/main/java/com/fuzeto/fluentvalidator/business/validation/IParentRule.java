package com.fuzeto.fluentvalidator.business.validation;

import br.com.fluentvalidator.context.ValidationResult;
import com.fuzeto.fluentvalidator.domain.model.Parent;

public interface IParentRule {

    ValidationResult validate(Parent parent)    ;
}
