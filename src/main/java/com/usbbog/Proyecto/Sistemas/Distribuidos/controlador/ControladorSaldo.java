package com.usbbog.Proyecto.Sistemas.Distribuidos.controlador;

import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaceService.IsaldoService;
import com.usbbog.Proyecto.Sistemas.Distribuidos.interfaces.saldoQuery;
import com.usbbog.Proyecto.Sistemas.Distribuidos.modelo.saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping
public class ControladorSaldo {

    @Autowired
    private IsaldoService service;

    @Autowired
    private saldoQuery query;

    @GetMapping("/user/saldo/{idsaldo}")
    public String goMoney(@PathVariable int idsaldo, Model model){
        Optional<saldo> money = service.listarSaldoId(idsaldo);
        money.ifPresent(dinero -> model.addAttribute("saldo", dinero));
        return "userPages/money";
    }

    @GetMapping("/saldo/{usuario}")
    public String showSaldo(@PathVariable int usuario){
        query.findByUsuario(usuario);
        return "userPages/money";
    }

    @PostMapping("/admin/cargarcuenta")
    public String cargarCuenta (saldo p, Model model){
        Optional<saldo> money = service.listarSaldoId(p.getIdsaldo());
        saldo saldoactual = money.get();
        saldoactual.setIdsaldo(p.getIdsaldo());
        saldoactual.setUsuario(p.getUsuario());
        saldoactual.setDinero(saldoactual.getDinero() + p.getDinero());
        service.CreateSaldo(saldoactual);
        return "redirect:/user/saldo/" + p.getIdsaldo();
    }

    @PostMapping("/admin/enviardinero")
    public String enviarDinero (saldo p, Model model){
        Optional<saldo> money = service.listarSaldoId(p.getIdsaldo());
        saldo saldoactual = money.get();

        //Encontrando al usuario
        saldo destino = query.findByUsuario(p.getUsuario()).get(0);

        //Enviando dinero
        destino.setDinero(destino.getDinero() + p.getDinero());

        saldoactual.setDinero(saldoactual.getDinero() - p.getDinero());
        service.CreateSaldo(destino);
        return "redirect:/user/saldo/" + p.getIdsaldo();
    }

    @GetMapping("/admin/updatesaldo/{id}")
    public String formMoney(@PathVariable int id, Model model){
        Optional<saldo> saldo = service.listarSaldoId(id);
        model.addAttribute("saldo", saldo);
        return "userPages/moneyform";
    }

    @GetMapping("/admin/sendsaldo/{id}")
    public String formEnviarMoney(@PathVariable int id, Model model){
        Optional<saldo> saldo = service.listarSaldoId(id);
        model.addAttribute("saldo", saldo);
        return "userPages/enviarmoneyform";
    }

}
