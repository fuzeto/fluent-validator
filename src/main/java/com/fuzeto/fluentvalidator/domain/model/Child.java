package com.fuzeto.fluentvalidator.domain.model;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Child {

    private UUID id;
    private String name;
    private Integer age;
}
