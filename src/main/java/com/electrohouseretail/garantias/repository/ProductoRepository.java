package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
