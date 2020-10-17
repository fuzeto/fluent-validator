package com.fuzeto.fluentvalidator.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ParentDto {

    private String name;
    private Integer age;
    private List<String> cities;
    private List<ChildDto> children;
}
