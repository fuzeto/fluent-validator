package com.fuzeto.fluentvalidator.web.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    private String code;
    private String message;
    private List<Field> fields;

}
