package com.example.votinginterviewapp.business.candidate.boundary;

import com.example.votinginterviewapp.business.candidate.model.dto.CandidateDto;

import java.util.List;

public interface CandidateOperation {
    CandidateDto addCandidate(CandidateDto candidateDto);
    List<CandidateDto> getCandidates();
}
