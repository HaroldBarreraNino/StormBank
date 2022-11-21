package com.usbbog.Proyecto.Sistemas.Distribuidos.services;

import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaceService.IsaldoService;
import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces.Isaldo;
import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class saldoService implements IsaldoService {

    @Autowired
    private Isaldo data;

    @Override
    public List<saldo> listarSaldos() {
        return (List<saldo>) data.findAll();
    }

    @Override
    public Optional<saldo> listarSaldoId(int id) {
        return data.findById(id);
    }

    @Override
    public int CreateSaldo(saldo p) {
        int res = 0;
        saldo saldo = data.save(p);
        if (!saldo.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void DeleteSaldo(Integer id) {
        data.deleteById(id);
    }
}
