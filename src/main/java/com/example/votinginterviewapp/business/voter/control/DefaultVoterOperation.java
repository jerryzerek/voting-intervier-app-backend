package com.example.votinginterviewapp.business.voter.control;

import com.example.votinginterviewapp.business.candidate.control.CandidateRepository;
import com.example.votinginterviewapp.business.candidate.model.Candidate;
import com.example.votinginterviewapp.business.voter.boundary.VoterOperation;
import com.example.votinginterviewapp.business.voter.error.BusinessException;
import com.example.votinginterviewapp.business.voter.error.NotFoundException;
import com.example.votinginterviewapp.business.voter.model.Voter;
import com.example.votinginterviewapp.business.voter.model.dto.VoterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultVoterOperation implements VoterOperation {
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;


    @Override
    public VoterDto addVoter(VoterDto voterDto) {
        Voter voter = Voter.builder()
                .name(voterDto.getName())
                .build();
        Voter savedVoter = voterRepository.save(voter);
        return VoterDto.builder()
                .id(savedVoter.getId())
                .name(savedVoter.getName())
                .build();
    }

    @Override
    public List<VoterDto> getVoters() {
        List<VoterDto> voterDtos = voterRepository.findAll().stream()
                .map(voter -> VoterDto.builder()
                        .id(voter.getId())
                        .name(voter.getName())
                        .hasVoted(voter.isHasVoted())
                        .candidateId(voter.getCandidate() != null ? voter.getCandidate().getId() : null)
                        .build())
                .toList();
        return voterDtos;
    }

    @Override
    public void setVote(Long voterId, Long candidateId) {
        Voter voter = voterRepository.findById(voterId).orElseThrow(NotFoundException::new);
        if (voter.isHasVoted()) {
            throw new BusinessException("Voter has already voted!");
        }
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(NotFoundException::new);
        voter.setCandidate(candidate);
        voter.markAsVoted();
        voterRepository.save(voter);
    }
}
