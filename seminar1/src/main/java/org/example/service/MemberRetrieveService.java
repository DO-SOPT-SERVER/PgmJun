package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.MemberGetResponse;
import org.example.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberRetrieveService {
    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getMemberById(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
    }
}
