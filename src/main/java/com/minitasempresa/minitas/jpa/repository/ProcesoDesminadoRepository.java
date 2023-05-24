package com.minitasempresa.minitas.jpa.repository;
import com.minitasempresa.minitas.jpa.entity.ProcesoDesminado;
import com.minitasempresa.minitas.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProcesoDesminadoRepository extends JpaRepository<ProcesoDesminado, Long> {
    List<ProcesoDesminado> findByRegion(String region);
}
