package org.example.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SOPT {

    private int generation;

    @Enumerated(EnumType.STRING)
    private Part part;

    protected void changeGeneration(int generation) {
        this.generation = generation;
    }

    protected void changePart(Part part) {
        this.part = part;
    }
}
