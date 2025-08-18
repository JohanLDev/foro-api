package com.example.foro_api.domain.topico;

import com.example.foro_api.domain.ValidacionException;
import com.example.foro_api.domain.curso.CursoRepository;
import com.example.foro_api.domain.models.Topico;
import com.example.foro_api.domain.topico.validaciones.ValidacionDeTopicos;
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

    @Autowired
    private List<ValidacionDeTopicos> validadores;

    public DatosDetalleTopico registrar(DatosRegistroTopico datos){

        var autor = usuarioRepository.getReferenceById(datos.idUsuario());
        var curso = cursoRepository.findByNombre(datos.nombreCurso());

        validadores.forEach(v -> v.validar(datos));

        var topico = new Topico(datos,autor,curso);
        repository.save(topico);

        return new DatosDetalleTopico(topico);
    }

    public List<DatosDetalleTopico> obtener(){

        return repository.findAll().stream()
                .map(t -> new DatosDetalleTopico(t.getId(),t.getTitulo(),t.getMensaje(),t.getFechaCreacion()))
                .collect(Collectors.toList());
    }


    public DatosDetalleTopico detallar(Long id) {
        var topico = repository.getReferenceById(id);

        if(topico == null){
            throw new ValidacionException("No existe un tópico con el id proporcionado");
        }

        return new DatosDetalleTopico(topico);
    }

    public DatosDetalleTopico actualizar(Long id, DatosActualizacionTopico datos) {

        var topicoBuscado = repository.findById(id);

        if(topicoBuscado.isEmpty()){
           throw new ValidacionException("No se encontró un tópico con el id proporcionado");
        }

        var topico = topicoBuscado.get();
        var usuarioBuscado = usuarioRepository.findById(datos.idUsuario());

        if(usuarioBuscado.isEmpty()){
            throw new ValidacionException("No existe un autor con el id proporcionado");
        }

        topico.actualizar(datos,usuarioBuscado.get());

        return new DatosDetalleTopico(topico);
    }

    public void eliminar(Long id) {

        if(!repository.existsById(id)){
            throw new ValidacionException("Topico a eliminar no existe");
        }

        repository.deleteById(id);
    }
}
