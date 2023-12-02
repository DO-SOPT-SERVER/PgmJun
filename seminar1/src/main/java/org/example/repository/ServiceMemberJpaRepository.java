package org.example.repository;

import java.util.Optional;
import org.example.domain.ServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceMemberJpaRepository extends JpaRepository<ServiceMember, Long> {
    Optional<ServiceMember> findByNickname(String nickname);
}
