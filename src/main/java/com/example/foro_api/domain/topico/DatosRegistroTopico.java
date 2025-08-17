package com.example.foro_api.domain.topico;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

public record DatosRegistroTopico(
        @NotNull Long idUsuario,
        @NotNull String mensaje,
        @NotNull String nombreCurso,
        @NotNull String titulo

) {
}
