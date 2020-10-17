package com.fuzeto.fluentvalidator.domain.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Parent {

    private UUID id;
    private String name;
    private Integer age;
    private List<String> cities;
    private List<Child> children;

}
