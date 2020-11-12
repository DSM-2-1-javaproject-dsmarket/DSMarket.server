package com.dsmarket.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Getter
@AllArgsConstructor
@Valid
public class GetPageRequest {

    private int page;

    private int size;

    private Sort.Direction direction;

}
