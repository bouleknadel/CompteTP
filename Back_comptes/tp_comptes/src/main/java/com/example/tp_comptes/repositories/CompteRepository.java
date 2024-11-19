package com.example.tp_comptes.repositories;

import com.example.tp_comptes.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
