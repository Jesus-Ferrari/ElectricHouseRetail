package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.OrdenRetiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrdenRetiroRepository extends JpaRepository<OrdenRetiro, Integer> {
}
