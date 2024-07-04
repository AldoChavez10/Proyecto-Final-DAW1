package com.rest01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest01.modelo.Cliente;

import com.rest01.repositorio.IClienteRepositorio;

@Service
public class ClienteServicioImplement implements IClienteService {
	@Autowired
	private IClienteRepositorio repositorio ;

	@Override
	public List<Cliente> listarCliente() {
	return repositorio.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return repositorio.save(cliente);
	}

	@Override
	public Optional<Cliente> buscarCliente(int codigo) {
	return repositorio.findById(codigo);
	}

	@Override
	public void eliminarCliente(int codigo) {
	repositorio.deleteById(codigo);
		
	}

}
