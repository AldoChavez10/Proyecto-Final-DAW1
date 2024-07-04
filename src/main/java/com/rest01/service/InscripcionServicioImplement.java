package com.rest01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest01.modelo.Inscripcion;
import com.rest01.repositorio.IInscripcionRepositorio;

@Service
public class InscripcionServicioImplement implements IInscripcionService {

    @Autowired
    private IInscripcionRepositorio repositorio;

    @Override
    public List<Inscripcion> listarInscripcion() {
        return repositorio.findAll();
    }

    @Override
    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {
        return repositorio.save(inscripcion);
    }

    @Override
    public Optional<Inscripcion> buscarInscripcion(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminarInscripcion(int id) {
        repositorio.deleteById(id);
    }
}
