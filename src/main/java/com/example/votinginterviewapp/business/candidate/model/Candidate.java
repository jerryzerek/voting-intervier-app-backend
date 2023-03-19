package com.example.votinginterviewapp.business.candidate.model;

import com.example.votinginterviewapp.business.voter.model.Voter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Candidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(
            targetEntity = Voter.class,
            mappedBy = "candidate",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Voter> voters = new ArrayList<>();
}
