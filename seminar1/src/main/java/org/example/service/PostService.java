package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.Category;
import org.example.domain.Member;
import org.example.domain.Post;
import org.example.dto.request.PostCreateRequest;
import org.example.dto.request.PostUpdateRequest;
import org.example.dto.response.PostGetResponse;
import org.example.repository.MemberJpaRepository;
import org.example.repository.PostJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final CategoryService categoryService;

    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                        .member(member)
                        .title(request.title())
                        .content(request.content()).build());
        return post.getId().toString();
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        post.updateContent(request.content());
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post, getCategoryByPost(post)))
                .toList();
    }

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        return PostGetResponse.of(post, getCategoryByPost(post));
    }

    @Transactional
    public void deleteById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        postJpaRepository.delete(post);
    }

    private Category getCategoryByPost(Post post) {
        return categoryService.getByCategoryId(post.getCategoryId());
    }
}
