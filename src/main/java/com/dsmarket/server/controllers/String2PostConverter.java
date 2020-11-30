package com.dsmarket.server.controllers;

import com.dsmarket.server.dto.request.WritePostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class String2PostConverter implements Converter<String, WritePostRequest> {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public WritePostRequest convert(String source) {
        return objectMapper.readValue(source, WritePostRequest.class);
    }

}
