package com.example.foro_api.domain.topico;

import com.example.foro_api.domain.curso.CursoRepository;
import com.example.foro_api.domain.models.Topico;
import com.example.foro_api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TopicoService {


    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;


    /**
     * Metodo encargado de enviar la solicitud
     * @param datos
     */
    public DatosDetalleTopico registrar(DatosRegistroTopico datos){

        var autor = usuarioRepository.getReferenceById(datos.idUsuario());
        var curso = cursoRepository.findByNombre(datos.nombreCurso());

        var topico = new Topico(datos,autor,curso);
        repository.save(topico);

        return new DatosDetalleTopico(topico);
    }



}
