package com.example.votinginterviewapp.business.voter.boundary;

import com.example.votinginterviewapp.business.voter.model.dto.VoterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
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
    public ResponseEntity<List<VoterDto>> getVoters() {
        return ResponseEntity.ok(voterOperation.getVoters());
    }

    @GetMapping("/voters/{voterId}/candidates/{candidateId}")
    public void setVote(@PathVariable Long voterId, @PathVariable Long candidateId) {
        voterOperation.setVote(voterId, candidateId);
    }
}
