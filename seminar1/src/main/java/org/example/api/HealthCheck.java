package org.example.api;

import java.util.HashMap;
import java.util.Map;

import org.example.dto.ApiResponse;
import org.example.dto.HealthCheckResponse;
import org.example.sample.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/health")
public class HealthCheck {

	@RequestMapping("/v1")
	public Map<String, String> healthCheckV1() {
		Map<String, String> response = new HashMap<>();
		response.put("status", "OK");
		return response;
	}

	@RequestMapping("/v2")
	public ResponseEntity<?> healthCheckV2() {
		Person.builder()
			.lastName("승준")
			.firstName("최")
			.build();
		return ResponseEntity.ok("OK");
	}

	@RequestMapping("/v3")
	public String healthCheckV3() {
		return "OK";
	}

	@RequestMapping("/v4")
	public ResponseEntity<?> healthCheckV4() {
		Map<String, String> response = new HashMap<>();
		response.put("status", "OK");

		return ResponseEntity.ok(response);
	}

	@RequestMapping("/v5")
	public ResponseEntity<HealthCheckResponse> healthCheckV5() {
		return ResponseEntity.ok(new HealthCheckResponse("ok"));
	}

	@RequestMapping("/v6")
	public ApiResponse healthCheckV6() {
		return ApiResponse.success(HttpStatus.OK);
	}
}
