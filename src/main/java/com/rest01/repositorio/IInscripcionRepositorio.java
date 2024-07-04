package com.rest01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest01.modelo.Inscripcion;


public interface IInscripcionRepositorio extends JpaRepository<Inscripcion, Integer> {

}
