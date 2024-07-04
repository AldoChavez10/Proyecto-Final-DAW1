package com.rest01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest01.modelo.Membresia;
import com.rest01.repositorio.IMembresiaRepositorio;

@Service
public class MembresiaServicioImplement implements IMembresiaService {

    @Autowired
    private IMembresiaRepositorio repositorio;

    @Override
    public List<Membresia> listarMembresia() {
        return repositorio.findAll();
    }

    @Override
    public Membresia guardarMembresia(Membresia membresia) {
        return repositorio.save(membresia);
    }

    @Override
    public Optional<Membresia> buscarMembresia(int codigo) {
        return repositorio.findById(codigo);
    }

    @Override
    public void eliminarMembresia(int codigo) {
        repositorio.deleteById(codigo);
    }
}
