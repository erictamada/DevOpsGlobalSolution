package com.fiap.globalsolutionv2.repository;

import com.fiap.globalsolutionv2.model.Recompensa;
import com.fiap.globalsolutionv2.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResiduoRepository extends JpaRepository<Residuo, Long> {

    Optional<Residuo> findResiduoByCodigoDeBarras(String codigoDeBarras);
}
