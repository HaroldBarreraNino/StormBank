package com.usbbog.Proyecto.Sistemas.Distribuidos.interfaceService;

import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.saldo;

import java.util.List;
import java.util.Optional;

public interface IsaldoService {
    public List<saldo> listarSaldos();
    public Optional<saldo> listarSaldoId(int id);
    public int CreateSaldo(saldo p);
    public void DeleteSaldo(Integer id);
}
