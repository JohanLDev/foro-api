package com.example.foro_api.domain.topico;

import com.example.foro_api.domain.ValidacionException;
import com.example.foro_api.domain.curso.CursoRepository;
import com.example.foro_api.domain.models.Topico;
import com.example.foro_api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TopicoService {


    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;


    public DatosDetalleTopico registrar(DatosRegistroTopico datos){

        var autor = usuarioRepository.getReferenceById(datos.idUsuario());
        var curso = cursoRepository.findByNombre(datos.nombreCurso());

        var topico = new Topico(datos,autor,curso);
        repository.save(topico);

        return new DatosDetalleTopico(topico);
    }

    public List<DatosDetalleTopico> obtener(){

        System.out.println("Pasó por aquí");

        return repository.findAll().stream()
                .map(t -> new DatosDetalleTopico(t.getId(),t.getTitulo(),t.getMensaje(),t.getFechaCreacion()))
                .collect(Collectors.toList());
    }


    public DatosDetalleTopico detallar(Long id) {
        var topico = repository.getReferenceById(id);

        System.out.println("LLeog aqui");

        if(topico == null){
            throw new ValidacionException("No existe un tópico con el id proporcionado");
        }

        return new DatosDetalleTopico(topico);
    }
}
