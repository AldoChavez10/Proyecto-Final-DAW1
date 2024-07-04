package com.rest01.controller;

import com.rest01.modelo.Membresia;
import com.rest01.service.IMembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MembresiaController {

    @Autowired
    private IMembresiaService membresiaService;

    @GetMapping("/listarMembresias")
    public String listarMembresias(Model model) {
        model.addAttribute("membresias", membresiaService.listarMembresia());
        return "listarMembresias"; // Vista para listar membresías
    }

    @GetMapping("/nuevaMembresia")
    public String nuevaMembresia(Model model) {
        model.addAttribute("membresia", new Membresia());
        return "FormMembresia"; // Vista para el formulario de nueva membresía
    }

    @GetMapping("/editarMembresia/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        Optional<Membresia> membresia = membresiaService.buscarMembresia(id);
        if (membresia.isPresent()) {
            model.addAttribute("membresia", membresia.get());
            return "FormMembresia"; // Vista para el formulario de editar membresía
        } else {
            // Manejar caso donde la membresía no existe
            return "redirect:/listarMembresias";
        }
    }

    @PostMapping("/editarMembresia/{id}")
    public String actualizarMembresia(@PathVariable int id, @ModelAttribute("membresia") Membresia membresia) {
        membresia.setId(id); // Asegurar que el ID de la membresía se establezca correctamente
        membresiaService.guardarMembresia(membresia);
        return "redirect:/listarMembresias";
    }

    @PostMapping("/saveMembresia")
    public String guardarMembresia(@ModelAttribute("membresia") Membresia membresia) {
        membresiaService.guardarMembresia(membresia);
        return "redirect:/listarMembresias";
    }

    @GetMapping("/eliminarMembresia/{id}")
    public String eliminarMembresia(@PathVariable int id) {
        membresiaService.eliminarMembresia(id);
        return "redirect:/listarMembresias";
    }
}
