package com.example.votinginterviewapp.business.candidate.boundary;

import com.example.votinginterviewapp.business.candidate.model.dto.CandidateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class CandidateResource {

    private final CandidateOperation candidateOperation;

    @PostMapping("/candidates")
    @ResponseStatus(HttpStatus.CREATED)
    public CandidateDto addCandidate(@RequestBody CandidateDto candidateDto) {
        return candidateOperation.addCandidate(candidateDto);
    }

    @GetMapping("/candidates")
    public List<CandidateDto> getCandidates() {
        return candidateOperation.getCandidates();
    }
}
