package com.example.votinginterviewapp.business.voter.boundary;

import com.example.votinginterviewapp.business.voter.model.Voter;
import com.example.votinginterviewapp.business.voter.model.dto.VoterDto;

import java.util.List;

public interface VoterOperation {
    VoterDto addVoter(VoterDto voterDto);
    List<VoterDto> getVoters();
    void setVote(Long voterId, Long candidateId);
}
