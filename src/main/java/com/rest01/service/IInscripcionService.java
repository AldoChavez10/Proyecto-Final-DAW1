package com.rest01.service;

import java.util.List;
import java.util.Optional;


import com.rest01.modelo.Inscripcion;


public interface IInscripcionService {
public List<Inscripcion> listarInscripcion();
public Inscripcion guardarInscripcion(Inscripcion Inscripcion);
public Optional <Inscripcion> buscarInscripcion (int codigo);
public void eliminarInscripcion(int codigo);
}
