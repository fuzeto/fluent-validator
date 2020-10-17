package com.fuzeto.fluentvalidator.business;

import com.fuzeto.fluentvalidator.business.validation.IParentRule;
import com.fuzeto.fluentvalidator.dto.ParentDto;
import com.fuzeto.fluentvalidator.domain.mapper.ParentMapper;
import com.fuzeto.fluentvalidator.domain.model.Parent;
import org.springframework.stereotype.Service;

@Service
public class ParentBusinessImpl implements IParentBusiness {

    private final IParentRule parentRule;

    public ParentBusinessImpl(IParentRule parentRule) {
        this.parentRule = parentRule;
    }

    @Override
    public ParentDto save(ParentDto parentDto) {

        Parent parent = ParentMapper.toObject(parentDto);

        parentRule.validate(parent);

        return ParentMapper.toDto(parent);
    }
}
