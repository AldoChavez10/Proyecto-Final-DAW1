package com.rest01.controller;

import com.rest01.modelo.Inscripcion;
import com.rest01.service.IInscripcionService;
import com.rest01.service.IClienteService;
import com.rest01.service.IMembresiaService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class InscripcionController {

    @Autowired
    private IInscripcionService inscripcionService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IMembresiaService membresiaService;

    @GetMapping("/api/inscripciones")
    @ResponseBody
    public List<InscripcionDTO> listarInscripciones() {
        List<Inscripcion> inscripciones = inscripcionService.listarInscripcion();
        return inscripciones.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private InscripcionDTO mapToDTO(Inscripcion inscripcion) {
        InscripcionDTO dto = new InscripcionDTO();
        dto.setId(inscripcion.getId());
        dto.setCliente(inscripcion.getCliente().getNombre());
        dto.setMembresia(inscripcion.getMembresia().getTipo());
        dto.setFechaInscripcion(inscripcion.getFechaInscripcion().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        return dto;
    }

    @GetMapping("/listarInscripciones")
    public String listarInscripciones(Model model) {
        model.addAttribute("inscripciones", inscripcionService.listarInscripcion());
        return "listarInscripciones"; // Vista para listar inscripciones
    }

    @GetMapping("/nuevaInscripcion")
    public String nuevaInscripcion(Model model) {
        model.addAttribute("inscripcion", new Inscripcion());
        model.addAttribute("clientes", clienteService.listarCliente());
        model.addAttribute("membresias", membresiaService.listarMembresia());
        return "FormInscripcion"; // Vista para el formulario de nueva inscripción
    }

    @PostMapping("/saveInscripcion")
    public String guardarInscripcion(@ModelAttribute("inscripcion") Inscripcion inscripcion) {
        inscripcionService.guardarInscripcion(inscripcion);
        return "redirect:/listarInscripciones";
    }

    @GetMapping("/editarInscripcion/{id}")
    public String editarInscripcion(@PathVariable int id, Model model) {
        Optional<Inscripcion> inscripcion = inscripcionService.buscarInscripcion(id);
        if (inscripcion.isPresent()) {
            model.addAttribute("inscripcion", inscripcion.get());
            model.addAttribute("clientes", clienteService.listarCliente());
            model.addAttribute("membresias", membresiaService.listarMembresia());
            return "FormInscripcion"; // Vista para el formulario de editar inscripción
        } else {
            // Manejar caso donde la inscripción no existe
            return "redirect:/listarInscripciones";
        }
    }

    @GetMapping("/eliminarInscripcion/{id}")
    public String eliminarInscripcion(@PathVariable int id) {
        inscripcionService.eliminarInscripcion(id);
        return "redirect:/listarInscripciones";
    }
}

// Clase DTO para la respuesta de la API
class InscripcionDTO {
    private int id;
    private String cliente;
    private String membresia;
    private String fechaInscripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}