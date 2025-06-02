package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
}
