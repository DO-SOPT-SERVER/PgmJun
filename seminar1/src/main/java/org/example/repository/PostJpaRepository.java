package org.example.repository;

import java.util.List;
import org.example.domain.Member;
import org.example.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);

}
