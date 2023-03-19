package com.example.votinginterviewapp.business.candidate.control;

import com.example.votinginterviewapp.business.candidate.boundary.CandidateOperation;
import com.example.votinginterviewapp.business.candidate.model.Candidate;
import com.example.votinginterviewapp.business.candidate.model.dto.CandidateDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultCandidateOperation implements CandidateOperation {

    private final CandidateRepository candidateRepository;

    @Override
    public CandidateDto addCandidate(CandidateDto candidateDto) {
        Candidate candidate = Candidate.builder()
                .name(candidateDto.getName())
                .build();
        Candidate savedCandidate = candidateRepository.save(candidate);
        return toCandidateDto(savedCandidate);
    }

    @Override
    public List<CandidateDto> getCandidates() {
        List<Candidate> allCandidates = candidateRepository.findAll();
        return allCandidates.stream()
                .map(this::toCandidateDto)
                .toList();
    }

    private CandidateDto toCandidateDto(Candidate candidate) {
        return CandidateDto.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .votersCount(Objects.isNull(candidate.getVoters()) ? 0 : candidate.getVoters().size())
                .build();
    }
}
