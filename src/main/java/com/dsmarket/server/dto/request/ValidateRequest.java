package com.dsmarket.server.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ValidateRequest {
	
	private String email;
	
	private String key;
}
