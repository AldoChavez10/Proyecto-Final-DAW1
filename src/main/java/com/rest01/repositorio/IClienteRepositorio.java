package com.rest01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest01.modelo.Cliente;


public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {

}
