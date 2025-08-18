package com.example.foro_api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

public record DatosRegistroTopico(
        @NotNull(message = "Id de usuario no enviado") Long idUsuario,
        @NotBlank(message = "Mensaje no enviado") String mensaje,
        @NotBlank(message = "Nombre de curso no enviado") String nombreCurso,
        @NotBlank(message = "El titulo no fue enviado") String titulo

) {
}
