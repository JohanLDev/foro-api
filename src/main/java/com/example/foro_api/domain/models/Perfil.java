package com.example.foro_api.domain.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfiles")
@Entity(name = "Perfil")
public class Perfil {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;



}
