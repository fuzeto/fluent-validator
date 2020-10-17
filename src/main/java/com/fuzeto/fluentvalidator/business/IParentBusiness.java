package com.fuzeto.fluentvalidator.business;

import com.fuzeto.fluentvalidator.dto.ParentDto;
import com.fuzeto.fluentvalidator.domain.model.Parent;

public interface IParentBusiness {

    public ParentDto save(ParentDto parentDto);
}
