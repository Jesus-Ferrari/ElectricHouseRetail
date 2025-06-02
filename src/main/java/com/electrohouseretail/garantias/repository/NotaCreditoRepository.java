package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.NotaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NotaCreditoRepository extends JpaRepository<NotaCredito, Integer> {
}
