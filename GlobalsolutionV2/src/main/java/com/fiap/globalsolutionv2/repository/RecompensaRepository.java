package com.fiap.globalsolutionv2.repository;

import com.fiap.globalsolutionv2.model.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {
}
