package com.rest01.service;

import java.util.List;
import java.util.Optional;

import com.rest01.modelo.Cliente;


public interface IClienteService {
public List<Cliente> listarCliente();
public Cliente guardarCliente(Cliente Cliente);
public Optional <Cliente> buscarCliente (int codigo);
public void eliminarCliente(int codigo);
}
