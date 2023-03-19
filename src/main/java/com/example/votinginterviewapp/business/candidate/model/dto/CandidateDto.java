package com.example.votinginterviewapp.business.candidate.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CandidateDto {
    private final Long id;
    private final String name;
    private final int votersCount;
}
