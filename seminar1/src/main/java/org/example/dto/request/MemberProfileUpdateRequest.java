package org.example.dto.request;

import org.example.domain.Part;


public record MemberProfileUpdateRequest(

        long memberId,
        int generation,
        Part part
) {
}
