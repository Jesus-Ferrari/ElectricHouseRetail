package com.electrohouseretail.garantias.repository;

import com.electrohouseretail.garantias.model.Solicitud;
import com.electrohouseretail.garantias.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsernameAndPassword(String username, String password);

    List<Usuario> findByRolId(Integer rolId);

}

