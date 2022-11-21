package com.usbbog.Proyecto.Sistemas.Distribuidos.interfaceService;

import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.usuario;

import java.util.List;
import java.util.Optional;

public interface IusuarioService {
    public List<usuario> listarUsuarios();
    public Optional<usuario> listarUsuariosId(int id);
    public int CreateUsuarios(usuario p);
    public void DeleteUsuarios(int id);
}
