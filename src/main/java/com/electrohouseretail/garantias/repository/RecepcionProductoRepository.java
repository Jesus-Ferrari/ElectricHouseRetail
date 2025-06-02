package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.RecepcionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecepcionProductoRepository extends JpaRepository<RecepcionProducto, Integer> {
}
