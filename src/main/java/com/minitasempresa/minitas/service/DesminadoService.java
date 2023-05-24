package com.minitasempresa.minitas.service;

import com.minitasempresa.minitas.jpa.entity.ProcesoDesminado;


import java.util.List;

public interface DesminadoService {

    Iterable<ProcesoDesminado> listarProcesosDesminado();
    List<ProcesoDesminado> listarProcesosDesminadoPorRegion(String region);
    ProcesoDesminado agregarProcesoDesminado(ProcesoDesminado procesoDesminado);
    ProcesoDesminado actualizarProcesoDesminado(Long id, ProcesoDesminado procesoDesminado);
    void eliminarProcesoDesminado(Long id);
}
