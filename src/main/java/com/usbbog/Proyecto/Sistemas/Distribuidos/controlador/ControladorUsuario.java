package com.usbbog.Proyecto.Sistemas.Distribuidos.controlador;

import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaceService.IsaldoService;
import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaceService.IusuarioService;
import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces.saldoQuery;
import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces.usuarioQuery;
import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.saldo;
import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ControladorUsuario {

    @Autowired
    private IusuarioService service;

    @Autowired
    private IsaldoService saldoservice;

    @Autowired
    private usuarioQuery query;

    @Autowired
    private saldoQuery saldoquery;
    private SistemaCifrado sc = new SistemaCifrado();

    //CRUD
    @GetMapping("/admin/listaUsuarios")
    public String listar(Model model){
        List<usuario> usuarios = service.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "adminPages/listausuarios";
    }

    @GetMapping("/admin/newusuario")
    public String newUsuarioForm(Model model){
        model.addAttribute("usuario", new usuario());
        return "adminPages/adminformusuario";
    }

    @PostMapping("/admin/createusuario")
    public String createUsuario (usuario p, Model model){
        service.CreateUsuarios(p);
        return "redirect:/admin/listaUsuarios";
    }

    @GetMapping("/admin/updateusuario/{id}")
    public String updateUsuario(@PathVariable int id, Model model){
        Optional<usuario> usuario = service.listarUsuariosId(id);
        model.addAttribute("usuario", usuario);
        return "adminPages/adminformusuario";
    }

    @GetMapping("/admin/deleteusuario/{id}")
    public String deleteVideo(Model model, @PathVariable int id) {
        service.DeleteUsuarios(id);
        return "redirect:/admin/listaUsuarios";
    }

    //LOGIN Y REGISTER
    @GetMapping("/user/register")
    public String irRegister(Model model){
        model.addAttribute("usuario", new usuario());
        return "userPages/register";
    }

    @PostMapping("/user/createusuario")
    public String signIn (usuario p, Model model){
        service.CreateUsuarios(p);
        saldo money = new saldo();
        money.setUsuario(p.getIdusuario());
        money.setDinero(0f);
        saldoservice.CreateSaldo(money);
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String irLogin(Model model){
        model.addAttribute("usuario", new usuario());
        return "userPages/login";
    }

    @PostMapping("/user/logging")
    public RedirectView LogIn(usuario p, Model model, RedirectAttributes redirectAttributes){
        RedirectView rv = new RedirectView();
        String cClave = sc.Cifrar(p.getClave());
        List<usuario> users = query.findByUsernameAndClave(p.getUsername(), cClave);
        usuario loguser = users.get(0);
        if (p.getUsername() == null || p.getClave() == null){
            rv.setContextRelative(true);
            rv.setUrl("/user/login");
            return rv;
        }else if(loguser.getUsername().equals("admin") && sc.Descifrar(loguser.getClave()).equals(p.getClave())){
            rv.setContextRelative(true);
            rv.setUrl("/admin/listaUsuarios");
            return rv;
        } else if (loguser.getUsername().equals(p.getUsername()) && sc.Descifrar(loguser.getClave()).equals(p.getClave())) {
            rv.setContextRelative(true);
            rv.setUrl("/user/saldo/" + BuscarSaldo(loguser.getIdusuario()));
            return rv;
        } else {
            rv.setContextRelative(true);
            rv.setUrl("/user/login");
            return rv;
        }
    }

    public int BuscarSaldo(int usuario){
        List<saldo> saldos = saldoquery.findByUsuario(usuario);
        for (int i = 0; i < saldos.size(); i++) {
            System.out.println(saldos.get(i));
        }
        int idsaldo = saldos.get(0).getIdsaldo();
        return idsaldo;
    }
}
