package com.example.votinginterviewapp.business.voter.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class VoterDto {
    private final Long id;
    private final String name;
    private final boolean hasVoted;
    private final Long candidateId;
}
