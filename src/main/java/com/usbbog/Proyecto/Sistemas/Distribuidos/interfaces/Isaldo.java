package com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces;

import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.saldo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Isaldo extends CrudRepository<saldo, Integer> {
}
