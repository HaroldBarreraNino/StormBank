package com.usbbog.Proyecto.Sistemas.Distribuidos.services;

import com.usbbog.Proyecto.Sistemas.Distribuidos.controlador.SistemaCifrado;
import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaceService.IusuarioService;
import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces.Iusuario;
import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioService implements IusuarioService {

    @Autowired
    private Iusuario data;
    SistemaCifrado sc = new SistemaCifrado();

    @Override
    public List<usuario> listarUsuarios() {
        return (List<usuario>) data.findAll();
    }

    @Override
    public Optional<usuario> listarUsuariosId(int id) {
        return data.findById(id);
    }

    @Override
    public int CreateUsuarios(usuario p) {
        int res = 0;
        String nuevaClave = sc.Cifrar(p.getClave());
        p.setClave(nuevaClave);
        usuario user = data.save(p);
        if (!user.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void DeleteUsuarios(int id) {
        data.deleteById(id);
    }
}
