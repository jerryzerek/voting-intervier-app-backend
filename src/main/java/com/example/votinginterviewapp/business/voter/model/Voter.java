package com.example.votinginterviewapp.business.voter.model;

import com.example.votinginterviewapp.business.candidate.model.Candidate;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "candidate")
@EqualsAndHashCode(exclude = "candidate")
@Builder
@Getter
@Setter
@Entity
public class Voter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean hasVoted;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public void markAsVoted() {
        this.hasVoted = true;
    }
}
