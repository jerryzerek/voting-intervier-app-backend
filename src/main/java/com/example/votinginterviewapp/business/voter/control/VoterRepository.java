package com.example.votinginterviewapp.business.voter.control;

import com.example.votinginterviewapp.business.voter.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {
}
