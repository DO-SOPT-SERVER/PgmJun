package org.example.dto.response;

import org.example.domain.Member;
import org.example.domain.SOPT;

public record MemberProfileUpdateResponse(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {}
