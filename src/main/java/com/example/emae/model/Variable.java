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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Float value;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
