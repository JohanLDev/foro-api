package com.example.foro_api.domain.curso;

import com.example.foro_api.domain.models.Curso;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    Curso findByNombre(@NotNull String s);
}
