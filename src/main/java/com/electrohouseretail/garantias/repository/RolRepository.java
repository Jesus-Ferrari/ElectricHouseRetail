package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
