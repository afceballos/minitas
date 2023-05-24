package com.minitasempresa.minitas.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "procesos_desminado")
@Getter
@Setter
public class ProcesoDesminado implements Serializable {

    @Serial
    private static final long serialVersionUID = -237790724208336663L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubicacion;

    private String region;

    private String tipoDesminado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;


}

