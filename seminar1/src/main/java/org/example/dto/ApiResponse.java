package org.example.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse <T>{

	private final HttpStatus status;
	private final String message;
	private T data;

	public static <T> ApiResponse<T> success(HttpStatus status, String message) {
		return new ApiResponse(status, message);
	}

	public static <T> ApiResponse<T> success(HttpStatus status, String message, T data) {
		return new ApiResponse(status, message, data);
	}

	public static <T> ApiResponse<T> fail(HttpStatus status, String message) {
		return new ApiResponse(status, message);
	}
}
