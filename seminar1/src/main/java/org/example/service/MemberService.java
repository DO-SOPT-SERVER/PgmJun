package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Member;
import org.example.dto.request.MemberCreateRequest;
import org.example.dto.request.MemberProfileUpdateRequest;
import org.example.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public void create(MemberCreateRequest request) {
        memberJpaRepository.save(Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build());
    }

    public void update(MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findById(request.memberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 맴버입니다."));

        member.changeSoptProfile(request);
    }

    public void delete(Long memberId) {
        Member member = memberJpaRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 맴버입니다."));

        memberJpaRepository.delete(member);
    }
}
