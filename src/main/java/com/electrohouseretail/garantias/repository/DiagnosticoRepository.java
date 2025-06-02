package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
}
