package org.example.api;

import java.net.URI;

import org.example.dto.request.MemberCreateRequest;
import org.example.dto.response.MemberGetResponse;
import org.example.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/{memberId}/v1")
	public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId) {
		return ResponseEntity.ok(memberService.getMemberByIdV1(memberId));
	}

	@GetMapping("/{memberId}/v2")
	public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
		return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
	}

	@PostMapping
	public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
		return ResponseEntity.created(memberService.create(request)).build();
	}
}