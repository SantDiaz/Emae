package com.example.emae.services;

import com.example.emae.model.Branch;
import com.example.emae.repositories.BranchRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;
    @PostConstruct
    public void init() {
        // Inicializa datos fijos
        if (branchRepository.count() == 0) {
            Branch branch1 = new Branch();
            branch1.setBranch("A");
            branch1.setBranch("A.01.1.43");
            branch1.setConcept("Cultivo de vid");
            branch1.setUnits("Producción de Uva (en quintales)");

            Branch branch2 = new Branch();
            branch2.setBranch("A");
            branch2.setBranch("A.9");
            branch2.setConcept("Tomate para industria");
            branch2.setUnits("Producción de Tomate (en Tn)");

            // Agrega más ramas según sea necesario

            branchRepository.saveAll(Arrays.asList(branch1, branch2));
        }
    }
}