package com.fuzeto.fluentvalidator.domain.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Child {

    private String name;
    private Integer age;
}
