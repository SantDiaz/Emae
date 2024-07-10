package com.example.emae.repositories;

import com.example.emae.model.Variable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariableRepository extends JpaRepository<Variable, String> {
}
