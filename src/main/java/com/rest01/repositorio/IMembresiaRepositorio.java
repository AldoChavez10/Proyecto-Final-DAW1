package com.rest01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest01.modelo.Membresia;


public interface IMembresiaRepositorio extends JpaRepository<Membresia, Integer> {

}
