package com.fuzeto.fluentvalidator.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChildDto {

    private UUID id;
    private String name;
    private Integer age;
}
