package org.example.api;

import static org.example.api.constant.ResponseMessage.DELETE_MEMBER_SUCCESS_MESSAGE;
import static org.example.api.constant.ResponseMessage.FIND_MEMBER_PROFILE_SUCCESS_MESSAGE;
import static org.example.api.constant.ResponseMessage.SIGNUP_SUCCESS_MESSAGE;
import static org.example.api.constant.ResponseMessage.UPDATE_MEMBER_PROFILE_SUCCESS_MESSAGE;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.dto.ApiResponse;
import org.example.dto.request.MemberCreateRequest;
import org.example.dto.request.MemberProfileUpdateRequest;
import org.example.dto.response.MemberGetResponse;
import org.example.service.MemberRetrieveService;
import org.example.service.MemberService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRetrieveService memberRetrieveService;

    @GetMapping("/{memberId}")
    public ApiResponse<MemberGetResponse> getMemberProfile(@PathVariable Long memberId) {
        return ApiResponse.success(HttpStatus.OK, FIND_MEMBER_PROFILE_SUCCESS_MESSAGE,
                memberRetrieveService.getMemberById(memberId));
    }

    @PostMapping("/create")
    public ApiResponse<String> createMember(@RequestBody MemberCreateRequest request, HttpServletResponse response) {
        response.addHeader(HttpHeaders.LOCATION, "/api/v1/member/" + memberService.create(request));
        return ApiResponse.success(HttpStatus.CREATED, SIGNUP_SUCCESS_MESSAGE);
    }

    @PutMapping("/update")
    public ApiResponse<String> updateMember(@RequestBody final MemberProfileUpdateRequest request) {
        memberService.update(request);
        return ApiResponse.success(HttpStatus.OK, UPDATE_MEMBER_PROFILE_SUCCESS_MESSAGE);
    }

    @DeleteMapping("/delete/{memberId}")
    public ApiResponse<String> updateMember(@PathVariable final Long memberId) {
        memberService.delete(memberId);
        return ApiResponse.success(HttpStatus.OK, DELETE_MEMBER_SUCCESS_MESSAGE);
    }
}
