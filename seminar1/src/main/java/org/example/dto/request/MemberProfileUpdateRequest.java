package org.example.dto.request;

import org.example.domain.Part;

import lombok.Data;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}