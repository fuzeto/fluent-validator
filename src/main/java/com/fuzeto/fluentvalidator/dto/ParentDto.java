package com.fuzeto.fluentvalidator.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ParentDto {

    private UUID id;
    private String name;
    private Integer age;
    private List<String> cities;
    private List<ChildDto> children;
}
