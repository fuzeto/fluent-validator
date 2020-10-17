package com.fuzeto.fluentvalidator.domain.mapper;

import com.fuzeto.fluentvalidator.dto.ChildDto;
import com.fuzeto.fluentvalidator.dto.ParentDto;
import com.fuzeto.fluentvalidator.domain.model.Child;
import com.fuzeto.fluentvalidator.domain.model.Parent;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ParentMapper {

    public static Parent toObject(ParentDto dto) {

        List<Child> children = dto.getChildren().stream()
                .map(c -> Child.builder().id(c.getId()).name(c.getName()).age(c.getAge()).build())
                .collect(Collectors.toList());

        return Parent.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .age(dto.getAge())
                .cities(dto.getCities())
                .children(children)
                .build();
    }

    public static ParentDto toDto(Parent parent) {

        List<ChildDto> children = parent.getChildren().stream()
                .map(c -> ChildDto.builder().id(c.getId()).name(c.getName()).age(c.getAge()).build())
                .collect(Collectors.toList());

        return ParentDto.builder()
                .id(parent.getId())
                .name(parent.getName())
                .age(parent.getAge())
                .cities(parent.getCities())
                .children(children)
                .build();
    }
}
