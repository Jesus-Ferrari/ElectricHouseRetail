package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    List<Solicitud> findByUsuarioId(Integer usuarioId);

    Optional<Solicitud> findById(Integer id);


}
