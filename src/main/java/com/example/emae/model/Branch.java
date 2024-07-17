package com.example.emae.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "branch")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch")
    private String branch;

    @Column(name = "subBranch")
    private String subBranch;

    @Column(name = "concept")
    private String concept;

    @Column(name = "units")
    private String units;

    @OneToMany(mappedBy = "branch")
    private List<Variable> variables;
}
