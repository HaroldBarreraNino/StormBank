package com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces;

import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface saldoQuery extends JpaRepository<saldo, Integer> {
    List<saldo> findByUsuario(int usuario);
}
