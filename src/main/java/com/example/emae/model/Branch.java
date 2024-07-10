package com.example.emae.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "branch")
@NoArgsConstructor
@Getter
@Setter
public class Branch {

    @Id
    @Column(name = "branch")
    private String branch;

    @Column(name = "concept")
    private String concept;

    @Column(name = "sub_concept")
    private String subConcept;

    @ManyToOne
    @JoinColumn(name = "sub_branch")
    private Branch subBranch;

    @OneToMany(mappedBy = "subBranch")
    private List<Branch> subBranches;


    @Column(name = "informationSource")
    private String informationSource;
}
