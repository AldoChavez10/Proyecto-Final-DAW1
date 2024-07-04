package com.rest01.service;

import java.util.List;
import java.util.Optional;


import com.rest01.modelo.Membresia;


public interface IMembresiaService {
public List<Membresia> listarMembresia();
public Membresia guardarMembresia(Membresia Membresia);
public Optional <Membresia> buscarMembresia(int codigo);
public void eliminarMembresia(int codigo);
}
