package com.example.votinginterviewapp.business.voter.boundary;

import com.example.votinginterviewapp.business.voter.model.dto.VoterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VoterResource {

    private final VoterOperation voterOperation;

    @PostMapping("/voters")
    @ResponseStatus(HttpStatus.CREATED)
    public VoterDto addVoter(@RequestBody VoterDto voterDto) {
        return voterOperation.addVoter(voterDto);
    }

    @GetMapping("/voters")
    public List<VoterDto> getVoters() {
        return voterOperation.getVoters();
    }

    @PutMapping("/voters/{voterId}/candidates/{candidateId}")
    public void setVote(@PathVariable Long voterId, @PathVariable Long candidateId) {
        voterOperation.setVote(voterId, candidateId);
    }
}
