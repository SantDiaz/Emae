package com.example.emae.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "variable")
@NoArgsConstructor
@Getter
@Setter
public class Variable {

    @Id
    @Column(name = "sub_branch")
    private String subBranch;

    @Column(name = "variable")
    private String variable;

    @Column(name = "value")
    private Float value;

    @Column(name = "units")
    private String units;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "sub_branch", insertable = false, updatable = false)
    private Branch branch;
}
