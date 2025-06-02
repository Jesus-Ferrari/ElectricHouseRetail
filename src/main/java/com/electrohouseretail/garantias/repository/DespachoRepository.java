package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.Despacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DespachoRepository extends JpaRepository<Despacho, Integer> {
}
