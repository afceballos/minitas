package com.minitasempresa.minitas.controller;

import com.minitasempresa.minitas.jpa.entity.ProcesoDesminado;
import com.minitasempresa.minitas.service.DesminadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DesminadoService desminadoService;

    @GetMapping("/")
    public List<ProcesoDesminado> listarProcesosDesminado() {
        return (List<ProcesoDesminado>) desminadoService.listarProcesosDesminado();
    }
}