package com.example.votinginterviewapp.business.candidate.model.dto;

import com.example.votinginterviewapp.business.voter.model.Voter;
import com.example.votinginterviewapp.business.voter.model.dto.VoterDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@Builder
public class CandidateDto {
    private final Long id;
    private final String name;
    private final int votersCount;
}
