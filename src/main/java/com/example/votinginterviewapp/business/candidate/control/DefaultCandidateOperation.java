package com.example.votinginterviewapp.business.candidate.control;

import com.example.votinginterviewapp.business.candidate.boundary.CandidateOperation;
import com.example.votinginterviewapp.business.candidate.model.Candidate;
import com.example.votinginterviewapp.business.candidate.model.dto.CandidateDto;
import com.example.votinginterviewapp.business.voter.model.dto.VoterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCandidateOperation implements CandidateOperation {

    @Autowired
    private final CandidateRepository candidateRepository;

    @Override
    public CandidateDto addCandidate(CandidateDto candidateDto) {
        Candidate candidate = Candidate.builder()
                .name(candidateDto.getName())
                .build();
        Candidate savedCandidate = candidateRepository.save(candidate);
        return CandidateDto.builder()
                .name(savedCandidate.getName())
                .build();
    }

    @Override
    public List<CandidateDto> getCandidates() {
        List<Candidate> allCandidates = candidateRepository.findAll();
        return allCandidates.stream()
                .map(candidate -> CandidateDto.builder()
                        .id(candidate.getId())
                        .name(candidate.getName())
                        .votersCount(candidate.getVoters().size())
                        .build()
                )
                .toList();
    }
}
