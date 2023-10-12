package org.example.dto;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse {

	private final int code;
	private final String status;
	private final boolean success;

	public static ApiResponse success(HttpStatus status) {
		return new ApiResponse(status.value(), status.name(), true);
	}

	public static ApiResponse fail(HttpStatus status) {
		return new ApiResponse(status.value(), status.name(), false);
	}
}
