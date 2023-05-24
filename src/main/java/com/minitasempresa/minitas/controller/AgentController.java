package com.minitasempresa.minitas.controller;

import com.minitasempresa.minitas.jpa.entity.ProcesoDesminado;
import com.minitasempresa.minitas.service.DesminadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private DesminadoService desminadoService;

    @GetMapping("/")
    public List<ProcesoDesminado> listarProcesosDesminadoPorRegion(@RequestParam("region") String region) {
        return desminadoService.listarProcesosDesminadoPorRegion("Region1");
    }
}