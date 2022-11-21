package com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces;

import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usuarioQuery extends JpaRepository<usuario, Integer> {
    List<usuario> findByUsernameAndClave(String username, String clave);
}
