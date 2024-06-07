package com.fiap.globalsolutionv2.repository;

import com.fiap.globalsolutionv2.model.Lixeira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LixeiraRepository extends JpaRepository<Lixeira, Long> {
}
