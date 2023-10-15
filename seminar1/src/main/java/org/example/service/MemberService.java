package org.example.service;

import java.net.URI;

import org.example.domain.Member;
import org.example.dto.request.MemberCreateRequest;
import org.example.dto.response.MemberGetResponse;
import org.example.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberJpaRepository memberJpaRepository;

	public MemberGetResponse getMemberByIdV1(Long id) {
		Member member = memberJpaRepository.findById(id).get();
		return MemberGetResponse.of(member);
	}

	public MemberGetResponse getMemberByIdV2(Long id) {
		return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
			() -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
	}

	@Transactional
	public URI create(MemberCreateRequest request) {
		Member member =  memberJpaRepository.save(Member.builder()
			.name(request.name())
			.nickname(request.nickname())
			.age(request.age())
			.sopt(request.sopt())
			.build());

		return URI.create(member.getId().toString());
	}
}