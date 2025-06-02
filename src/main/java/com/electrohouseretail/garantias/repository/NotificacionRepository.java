package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {

    List<Notificacion> findBySolicitudId(Integer solicitudId);

    List<Notificacion> findBySolicitudUsuarioId(Integer idUsuario);

}
