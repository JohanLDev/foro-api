package com.example.foro_api.domain.topico;

import com.example.foro_api.domain.models.Topico;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTitulo(String titulo);

    boolean existsByMensaje(String mensaje);
}
