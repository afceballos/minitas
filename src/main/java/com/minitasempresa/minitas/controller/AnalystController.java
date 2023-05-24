package com.minitasempresa.minitas.controller;


import com.minitasempresa.minitas.jpa.entity.ProcesoDesminado;
import com.minitasempresa.minitas.service.DesminadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analyst")
public class AnalystController {
    @Autowired
    private DesminadoService desminadoService;

    @PostMapping("/")
    public ProcesoDesminado agregarProcesoDesminado(@RequestBody ProcesoDesminado procesoDesminado) {
        return desminadoService.agregarProcesoDesminado(procesoDesminado);
    }

    @PutMapping("/{id}")
    public ProcesoDesminado actualizarProcesoDesminado(@PathVariable("id") Long id, @RequestBody ProcesoDesminado procesoDesminado) {
        return desminadoService.actualizarProcesoDesminado(id, procesoDesminado);
    }

    @DeleteMapping("/{id}")
    public void eliminarProcesoDesminado(@PathVariable("id") Long id) {
        desminadoService.eliminarProcesoDesminado(id);
    }
}

