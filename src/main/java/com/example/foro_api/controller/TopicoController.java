package com.example.foro_api.controller;

import com.example.foro_api.domain.topico.DatosActualizacionTopico;
import com.example.foro_api.domain.topico.DatosDetalleTopico;
import com.example.foro_api.domain.topico.DatosRegistroTopico;
import com.example.foro_api.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {


    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder){

        DatosDetalleTopico datosDetalleTopico =  service.registrar(datos);

        // Le enviados en el header como puede detallar el tópico creado
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(datosDetalleTopico.id()).toUri();

        return ResponseEntity.created(uri).body(datosDetalleTopico);
    }

    @GetMapping
    public ResponseEntity obtener(){
        return ResponseEntity.ok(service.obtener());
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        return ResponseEntity.ok(service.detallar(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar( @PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos){
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }





}
