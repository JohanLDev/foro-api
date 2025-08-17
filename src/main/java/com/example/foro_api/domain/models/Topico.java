package com.example.foro_api.domain.models;


import com.example.foro_api.domain.topico.DatosRegistroTopico;
import com.example.foro_api.domain.topico.EstadoTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstadoTopico estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;


    /**
     * Constructor para crear un nuevo topico a partir de datos registro topicos
     * @param datos
     * @param usuario
     */
    public Topico(DatosRegistroTopico datos, Usuario usuario, Curso curso) {
        this.autor = usuario;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.titulo = datos.titulo();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoTopico.CREADO;
        this.curso = curso;
    }
}
