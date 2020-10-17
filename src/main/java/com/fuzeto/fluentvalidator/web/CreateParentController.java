package com.fuzeto.fluentvalidator.web;

import com.fuzeto.fluentvalidator.business.ParentBusinessImpl;
import com.fuzeto.fluentvalidator.dto.ParentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateParentController {

    ParentBusinessImpl parentBusiness;

    public CreateParentController(ParentBusinessImpl parentBusiness) {
        this.parentBusiness = parentBusiness;
    }

    @PostMapping("/new")
    public ResponseEntity<ParentDto> create(@RequestBody ParentDto content) {

        ParentDto parentCreated = parentBusiness.create(content);

        return ResponseEntity.ok(parentCreated);
    }
}
