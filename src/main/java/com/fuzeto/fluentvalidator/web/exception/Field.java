package com.fuzeto.fluentvalidator.web.exception;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Field {

    private String field;
    private String message;
    private String value;
}
