package com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces;

import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iusuario extends CrudRepository<usuario, Integer> {
}
