package com.dsmarket.server.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ValidateResponse {
	
	private String status;
	
	private String reason;
}
