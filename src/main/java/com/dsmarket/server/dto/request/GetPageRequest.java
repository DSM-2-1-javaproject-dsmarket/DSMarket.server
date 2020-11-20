package com.dsmarket.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@AllArgsConstructor
@Valid
public class GetPageRequest {

    @NotNull
    @Min(0)
    private int page;

    @NotNull
    @Min(1)
    private int size;

    @NotNull
    private Sort.Direction direction;

}
