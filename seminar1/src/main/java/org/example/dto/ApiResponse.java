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
	private T data;

	public static <T> ApiResponse<T> success(HttpStatus status) {
		return new ApiResponse(status);
	}

	public static <T> ApiResponse<T> success(HttpStatus status, T data) {
		return new ApiResponse(status, data);
	}

	public static <T> ApiResponse<T> fail(HttpStatus status) {
		return new ApiResponse(status);
	}
}
