package com.example.votinginterviewapp.business.voter.control;

import com.example.votinginterviewapp.business.candidate.control.CandidateRepository;
import com.example.votinginterviewapp.business.candidate.model.Candidate;
import com.example.votinginterviewapp.business.voter.boundary.VoterOperation;
import com.example.votinginterviewapp.shared.error.BusinessException;
import com.example.votinginterviewapp.shared.error.NotFoundException;
import com.example.votinginterviewapp.business.voter.model.Voter;
import com.example.votinginterviewapp.business.voter.model.dto.VoterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return toVoterDto(savedVoter);
    }

    @Override
    public List<VoterDto> getVoters() {
        return voterRepository.findAll().stream()
                .map(this::toVoterDto)
                .toList();
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

    private VoterDto toVoterDto(Voter voter) {
        return VoterDto.builder()
                .id(voter.getId())
                .name(voter.getName())
                .hasVoted(voter.isHasVoted())
                .candidateId(voter.getCandidate() != null ? voter.getCandidate().getId() : null)
                .build();
    }
}
