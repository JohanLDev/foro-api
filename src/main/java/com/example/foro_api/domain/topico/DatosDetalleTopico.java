package com.example.foro_api.domain.topico;

import com.example.foro_api.domain.models.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 LocalDateTime fechaCreacion ) {

    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(), topico.getMensaje(),topico.getFechaCreacion());
    }
}
