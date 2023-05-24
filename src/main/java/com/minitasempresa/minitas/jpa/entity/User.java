package com.minitasempresa.minitas.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 7565578515351236429L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String password;



    private String role;

}


