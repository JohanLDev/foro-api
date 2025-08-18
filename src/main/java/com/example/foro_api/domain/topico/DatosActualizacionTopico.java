package com.example.foro_api.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull Long idUsuario,
        @NotNull String mensaje,
        @NotNull String nombreCurso,
        @NotNull String titulo
) {
}
