package com.example.foro_api.domain.topico.validaciones;

import com.example.foro_api.domain.ValidacionException;
import com.example.foro_api.domain.topico.DatosRegistroTopico;
import com.example.foro_api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicoExistenPorMensaje implements ValidacionDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosRegistroTopico datos){

        if(datos.titulo() == null){
            return;
        }

        if(topicoRepository.existsByMensaje(datos.mensaje())){
            throw  new ValidacionException("Ya existe un topico con el mismo mensaje");
        }
    }


}
