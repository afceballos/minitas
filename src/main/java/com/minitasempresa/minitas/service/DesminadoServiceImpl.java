package com.minitasempresa.minitas.service;

import com.minitasempresa.minitas.jpa.entity.ProcesoDesminado;
import com.minitasempresa.minitas.jpa.repository.ProcesoDesminadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesminadoServiceImpl implements DesminadoService {
    @Autowired
    private ProcesoDesminadoRepository desminadoRepository;

    @Override
    public List<ProcesoDesminado> listarProcesosDesminado() {
        return (List<ProcesoDesminado>) desminadoRepository.findAll();
    }

    @Override
    public List<ProcesoDesminado> listarProcesosDesminadoPorRegion(String region) {
        return desminadoRepository.findByRegion(region);
    }

    @Override
    public ProcesoDesminado agregarProcesoDesminado(ProcesoDesminado procesoDesminado) {
        return desminadoRepository.save(procesoDesminado);
    }

    @Override
    public ProcesoDesminado actualizarProcesoDesminado(Long id, ProcesoDesminado procesoDesminado) {
        // Verificar si el proceso existe
        ProcesoDesminado procesoExistente = desminadoRepository.findById(id).orElse(null);
        if (procesoExistente != null) {
            procesoDesminado.setId(id); // Establecer el ID del proceso existente en el objeto actualizado
            return desminadoRepository.save(procesoDesminado);
        }
        return null; // El proceso no existe
    }

    @Override
    public void eliminarProcesoDesminado(Long id) {
        desminadoRepository.deleteById(id);
    }
}
