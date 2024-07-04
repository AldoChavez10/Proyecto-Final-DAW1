package com.rest01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rest01.modelo.Cliente;
import com.rest01.service.IClienteService;

import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "index2"; // Asegúrate de que index2.html esté en la carpeta de plantillas (src/main/resources/templates)
    }

    @GetMapping({"/listarClientes"})
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarCliente());
        return "listarClientes";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "FormCliente";
    }

    @PostMapping("/saveCliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/listarClientes";
    }

    @GetMapping("/editarCliente/{id}")
    public String editarCliente(@PathVariable int id, Model model) {
        Optional<Cliente> cliente = clienteService.buscarCliente(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "FormCliente";
        } else {
            // Manejar caso donde el cliente no existe
            return "redirect:/listarClientes";
        }
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable int id) {
        clienteService.eliminarCliente(id);
        return "redirect:/listarClientes";
    }
}
