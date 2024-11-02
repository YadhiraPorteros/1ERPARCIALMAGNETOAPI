package com.PARCIAL.repositorios;

import com.PARCIAL.entidades.DNA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DNARepository extends JpaRepository<DNA, Long> {
    Optional<DNA> findByDna(String dna); // Asegúrate de que sea findByDna

    long countByIsMutant(boolean isMutant);
}


