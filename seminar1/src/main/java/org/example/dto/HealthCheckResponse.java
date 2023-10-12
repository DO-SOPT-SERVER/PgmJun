package org.example.dto;

import lombok.Getter;

@Getter
public class HealthCheckResponse {
	private String status;

	public HealthCheckResponse(String status) {
		this.status = status;
	}
}
